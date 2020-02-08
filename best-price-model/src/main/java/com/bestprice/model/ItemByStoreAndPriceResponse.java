package com.bestprice.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.List;
import java.util.Map;

public class ItemByStoreAndPriceResponse {
   private Map<String, List<StoreByPrice>> itemByStoreAndPrice;

   public ItemByStoreAndPriceResponse(Map<String, List<StoreByPrice>> itemByStoreAndPrice) {
       this.itemByStoreAndPrice = itemByStoreAndPrice;
   }

   @JsonAnySetter
   public void setDetails(String key, List<StoreByPrice> value) {
       itemByStoreAndPrice.put(key, value);
   }
    public Map<String, List<StoreByPrice>> getItemByStoreAndPrice() {
        return itemByStoreAndPrice;
    }
}
