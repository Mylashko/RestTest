
package com.mkyong.rest;
 
import com.google.gson.Gson;
import org.apache.derby.impl.store.access.UTF;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

@Path("/vendor")
        public class VendorService {



    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") int msg) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Vendor vp = (Vendor) session.get(Vendor.class, msg);

        String output = "Vendor's name is : " + vp.getVendorname() +
                "<br>Vendor's country is : " + vp.getVendorcountry() +
                "<br>Vendor's city is : " + vp.getVendorcity() +
                "<br>Vendor's adress is : " + vp.getVendoradress() +
                "<br>Vendor's phone number is : " + vp.getVendorphone();

        session.getTransaction().commit();
        session.close();

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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(String vendor) {

        Gson gs = new Gson();

        Vendor vp = gs.fromJson(vendor, Vendor.class);
        Charset.forName("UTF-8").encode(vendor);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Vendor testVendor = (Vendor) session.get(Vendor.class, vp.getVendorId());
        testVendor.setVendoradress(vp.getVendoradress());
        testVendor.setVendorcity(vp.getVendorcity());
        testVendor.setVendorcountry(vp.getVendorcountry());
        testVendor.setVendorname(vp.getVendorname());
        testVendor.setVendorphone(vp.getVendorphone());

        session.update(testVendor);
        session.getTransaction().commit();
        session.close();

        return Response.status(200).build();

    }



}