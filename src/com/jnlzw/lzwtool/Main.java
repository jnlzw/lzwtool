package com.jnlzw.lzwtool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzw on 2019/9/25.
 */
public class Main {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("47.102.219.1",6379);
        jedis.auth("123");
        System.out.println(jedis.get("test"));
        jedis.flushAll();
        System.out.println(jedis.get("test"));
    }
}
