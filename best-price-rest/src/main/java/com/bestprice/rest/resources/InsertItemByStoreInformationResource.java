package com.bestprice.rest.resources;

import com.bestprice.model.ItemByStoreAndPriceResponse;
import com.bestprice.model.StoreByPrice;
import com.bestprice.util.Deserializer;
import com.bestprice.util.PopulateData;
import com.bestprice.util.RedisSource;
import com.bestprice.util.Verifier;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Path("")
public class InsertItemByStoreInformationResource {

    @POST
    @Path("/insert/item/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertItem(String itemByStoreAndPriceResponseJson) {
        ItemByStoreAndPriceResponse itemByStoreAndPriceResponse = new ItemByStoreAndPriceResponse();
        try {
            Map<String, List<StoreByPrice>> map = Deserializer.deserialize(itemByStoreAndPriceResponseJson, Map.class);
            itemByStoreAndPriceResponse.setItemByStoreAndPrice(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Verifier.verifyNotEmpty(itemByStoreAndPriceResponseJson, "string should not be empty");
        PopulateData populateData = new PopulateData(itemByStoreAndPriceResponse);
        String value = populateData.insertIntoCache();
        return value != null ? Response.status(Response.Status.CREATED.getStatusCode()).build() : Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
    }
}
