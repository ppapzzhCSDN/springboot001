package com.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @auth admin
 * @date
 * @Description
 */
public class JedisTest {

    @Test
    public void a() {
//        Jedis jedis = new Jedis();
        Jedis jedis = new Jedis("localhost", 6379);

//        jedis.set("string:name", "马云");
//        jedis.setex("string:name", 5, "马云");

//        jedis.lpush("list:a", "a", "b", "c");

//        List<String> lrange = jedis.lrange("list:a", 0, -1);
//        lrange.stream().forEach(System.out::println);

//        jedis.sadd("set:a","a","a","b");
//        Set<String> smembers = jedis.smembers("set:a");
//        for (String str:smembers){
//            System.out.println(str);
//        }

//        jedis.zadd("zset:a", 90, "马云");
//        jedis.zadd("zset:a", 80, "马冬梅");
//        jedis.zadd("zset:a", 70, "马云");
//
//        Set<String> zrange = jedis.zrange("zset:a", 0, -1);
//        for (String str : zrange) {
//            System.out.println(str);
//        }

        jedis.hset("hash:a", "name", "马什么梅");
        jedis.hset("hash:a", "age", "20");

        System.out.println(jedis.hget("hash:a","name"));

        jedis.close();

    }
}
