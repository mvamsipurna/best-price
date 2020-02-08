package com.bestprice.util;

import redis.clients.jedis.Jedis;

public class FetchItemFromDB {
    private String itemName;
    private Jedis jedisInstance = RedisSource.getRedisSourceInstance();
    public FetchItemFromDB(String itemName) {
        this.itemName = itemName;
    }

    public String fetch() {
        return jedisInstance.lpop(itemName) != null ? jedisInstance.lpop(itemName) : null;
    }
}
