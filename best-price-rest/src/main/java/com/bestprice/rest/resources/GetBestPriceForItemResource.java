package com.bestprice.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fetch")
public class GetBestPriceForItemResource {

    @GET
    @Path("/best-price/{item}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBestPriceForAnItem(@PathParam("item")  final String item) {
        System.out.println("This api calculates best price");
        return null;
    }
}
