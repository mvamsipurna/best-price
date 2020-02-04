package com.bestprice.rest.resources;

import com.bestprice.util.Verifier;
import com.bestprice.util.VerifierException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/fetch")
public class GetBestPriceForItemResource {

    private static final Logger LOGGER = Logger.getLogger(GetBestPriceForItemResource.class.getName());

    @GET
    @Path("/best-price/{item}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBestPriceForAnItem(@PathParam("item")  final String item) {
        try {
            Verifier.verifyNotNull(item, "item should not be null");
            Verifier.verifyNotEmpty(item, "not empty");
        } catch (final VerifierException verifierException) {
            LOGGER.log(Level.SEVERE,"generic error", verifierException);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return null;
    }
}
