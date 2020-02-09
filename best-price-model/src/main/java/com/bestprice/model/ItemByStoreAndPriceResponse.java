package com.bestprice.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class ItemByStoreAndPriceResponse {
    @JsonProperty("itemByStoreAndPrice")
   private Map<String, List<StoreByPrice>> itemByStoreAndPrice;

   @JsonAnySetter
    public void setItemByStoreAndPrice(Map<String, List<StoreByPrice>> itemByStoreAndPrice) {
        this.itemByStoreAndPrice = itemByStoreAndPrice;
    }

    @JsonAnyGetter
    public Map<String, List<StoreByPrice>> getItemByStoreAndPrice() {
        return itemByStoreAndPrice;
    }
}
