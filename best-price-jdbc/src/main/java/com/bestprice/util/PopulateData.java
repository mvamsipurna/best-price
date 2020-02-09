package com.bestprice.util;

import com.bestprice.model.ItemByStoreAndPriceResponse;
import com.bestprice.model.StoreByPrice;
import com.bestprice.model.StoreInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopulateData {
    private Jedis jedis = RedisSource.getRedisSourceInstance();
    private String itemName;
    private ItemByStoreAndPriceResponse itemByStoreAndPriceResponse;


    public PopulateData(ItemByStoreAndPriceResponse itemByStoreAndPriceResponse) {
        this.itemByStoreAndPriceResponse = itemByStoreAndPriceResponse;
    }
    public String insertIntoCache() {
        for(String item : itemByStoreAndPriceResponse.getItemByStoreAndPrice().keySet()) {
            try {
                return jedis.set(item, Serializer.serialize(itemByStoreAndPriceResponse.getItemByStoreAndPrice()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
