package com.bestprice.util;

import redis.clients.jedis.Jedis;

public class RedisSource {
    private static volatile Jedis redisSourceInstance;

    private RedisSource() {

    }

    public static Jedis getRedisSourceInstance() {
        if(redisSourceInstance == null) {
            synchronized (RedisSource.class) {
                if(redisSourceInstance == null) {
                    redisSourceInstance = new Jedis("127.0.0.1", 6379);
                }
            }
        }
        return redisSourceInstance;
    }
}
