package com.bestprice.rest.resources;

import com.bestprice.model.ItemByStoreAndPriceResponse;
import com.bestprice.util.PopulateData;
import com.bestprice.util.Verifier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class InsertItemByStoreInformationResource {

    public InsertItemByStoreInformationResource() {
        System.out.println("hi");
    }

    @POST
    @Path("/insert/item/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertItem(String itemByStoreAndPriceResponseJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        ItemByStoreAndPriceResponse itemByStoreAndPriceResponse = null;
        try {
            itemByStoreAndPriceResponse = objectMapper.readValue(itemByStoreAndPriceResponseJson, ItemByStoreAndPriceResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Verifier.verifyNotEmpty(itemByStoreAndPriceResponseJson, "string should not be empty");
        PopulateData populateData = new PopulateData(itemByStoreAndPriceResponse);
        int status = populateData.insertIntoCache();
        return status == 1 ? Response.status(Response.Status.CREATED.getStatusCode()).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
    }
}
