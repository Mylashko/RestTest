package com.mkyong.rest;

import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/goods")
public class GoodsService {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") int msg) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Goods gds = (Goods) session.get(Goods.class, msg);

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

        return Response.status(200).entity(output).build();

    }
}
