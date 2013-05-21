package com.mkyong.rest;
 
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
   	public Response getSent(String logPas) {
        Gson gs = new Gson();
        LogPasPojo lp= gs.fromJson(logPas, LogPasPojo.class);
   		String output = "Jersey say : " + logPas;

   		return Response.status(200).entity(output).build();

   	}

}