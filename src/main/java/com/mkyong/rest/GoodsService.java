package com.mkyong.rest;

import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.charset.Charset;

@Path("/goods")
public class GoodsService {

   /* @Provider
    public class EntityNotFoundMapper implements
            ExceptionMapper<EntityNotFoundException> {
        public Response toResponse(javax.persistence.EntityNotFoundException ex){
            return Response.status(404). entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }      */

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") int msg) {

        if(msg < 1)
            throw new WebApplicationException(
                    Response.status(400).entity("Id must be a positive integer!").build());

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Goods gds = (Goods) session.get(Goods.class, msg);

        if (gds == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        String output = "Goods' name is : " + gds.getGoodsname() +
                "<br>Goods' vendor is : " + gds.getGoodsvendor() +
                "<br>Goods' type is : " + gds.getGoodstype() +
                "<br>Goods' unit is : " + gds.getGoodsunit() +
                "<br>Goods' characteristics is : " + gds.getGoodscharacteristics();

        session.getTransaction().commit();
        session.close();

        return Response.status(200).entity(output).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSent(String goods) {
        Gson gs = new Gson();
        Goods gds= gs.fromJson(goods, Goods.class);
        String output = "Jersey say : " + goods;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(gds);
        session.getTransaction().commit();
        session.close();

       /* EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatedb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(gds);
        tx.commit();

        em.close();
        emf.close();
        */

        return Response.status(200).entity(output).build();

    }

    @DELETE
    @Path("/{param}")
    public Response delete(@PathParam("param") int msg) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Goods gds = (Goods) session.get(Goods.class, msg);
        session.delete(gds);

        String output = gds.getGoodsname() + " is deleted";

        session.getTransaction().commit();
        session.close();


        return Response.status(200).entity(output).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(String goods) {


        Gson gs = new Gson();
        Goods gds= gs.fromJson(goods, Goods.class);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Charset.forName("UTF-8").encode(goods);
        Goods testGoods = (Goods) session.get(Goods.class, gds.getGoodsId());
        testGoods.setGoodsname(gds.getGoodsname());
        testGoods.setGoodstype(gds.getGoodstype());
        testGoods.setGoodsunit(gds.getGoodsunit());
        testGoods.setGoodsvendor(gds.getGoodsvendor());
        testGoods.setGoodscharacteristics(gds.getGoodscharacteristics());

        session.update(testGoods);
        session.getTransaction().commit();
        session.close();

        return Response.status(200).build();

    }

}
