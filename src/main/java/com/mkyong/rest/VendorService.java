package com.mkyong.rest;
 
import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/vendor")
        public class VendorService {



        @GET
        @Path("/{param}")
        public Response getMsg(@PathParam("param") String msg) {

            String output = "Jersey say : " + msg;

            return Response.status(200).entity(output).build();

        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response getSent(String vendor) {
            Gson gs = new Gson();
            Vendor vp= gs.fromJson(vendor, Vendor.class);
            String output = "Jersey say : " + vendor;
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(vp);
            session.getTransaction().commit();
            session.close();

            return Response.status(200).entity(output).build();

        }



}