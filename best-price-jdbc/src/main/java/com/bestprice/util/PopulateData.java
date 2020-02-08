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
    public int insertIntoCache() {
       /* Map<String, List<StoreByPrice>> storeMap = new HashMap<>();
        //        StoreInformation storeInformation = new StoreInformation.StoreInformationBuilder("Walmart", 848449).emailInfo("abc@gmail.com").build();
        //        StoreByPrice storeByPrice = new StoreByPrice(storeInformation, 8);
        //        List<StoreByPrice> storeByPrices = new ArrayList<>();
        //        storeByPrices.add(storeByPrice);
        //        storeMap.put(itemName, storeByPrices);
        //        itemByStoreAndPriceResponse = new ItemByStoreAndPriceResponse(storeMap);
        //        try {
        //           return Serializer.serialize(itemByStoreAndPriceResponse);
        //        } catch (JsonProcessingException e) {
        //            e.printStackTrace();
        //        }
        //        //jedis.hmset(itemName, itemByStoreAndPriceResponse);*/
        for(String item : itemByStoreAndPriceResponse.getItemByStoreAndPrice().keySet()) {
            try {
                jedis.lpush(item, Serializer.serialize(itemByStoreAndPriceResponse));
                return 1;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
