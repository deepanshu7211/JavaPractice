package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 02/06/16.
 */
public class RedisJava {

    private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;

    private static JedisPool pool = null;

    public static void main(String[] args) {
//        connect();
        getList();
        getKeys();
        jesdisPool();
//        addSets();
        addHash();
    }

    public static void connect() {
        Jedis jedis = new Jedis("localhost");
        System.out.println(" connected successfully ");
        System.out.println(" server is running " + jedis.ping());
        jedis.set("key", "deep");
        System.out.println("key value :: " + jedis.get("key"));
    }

    public static void getList() {
        Jedis jedis = new Jedis("localhost");
        jedis.lpush("lkey", "redis");
        jedis.lpush("lkey", "mongo");
        jedis.lpush("lkey", "rabitmq");

        List<String> list = jedis.lrange("lkey", 0, -1);
        for (String str : list) {
            System.out.println("List values :: " + str);
        }

        System.out.println("now deleting the values.... ");
        jedis.del("lkey");
    }

    public static void delList() {

    }

    public static void getKeys() {
        Jedis jedis = new Jedis("localhost");
        Set<String> list = jedis.keys("*");
        for (String str : list) {
            System.out.println(str);
        }

    }

    public static void jesdisPool() {
        pool = new JedisPool(redisHost, redisPort);
        Jedis jedis = pool.getResource();
        System.out.println(" get resource successfully ");
//         System.out.println(jedis.ping());
    }

    public static void addSets() {
        //let us first add some data in our redis server using Redis SET.
        String key = "members";
        String member1 = "Sedarius";
        String member2 = "Richard";
        String member3 = "Joe";

        Jedis jedis = pool.getResource();

        try {

            jedis.sadd(key, member1, member2, member3);  // save to redis

            Set<String> members = jedis.smembers(key);
            for (String member : members) {
                System.out.println(member);
            }

        } catch (JedisException e) {
            //if something wrong happen, return it back to the pool
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
                jedis = null;
            }
        } finally {
            //it's important to return the Jedis instance to the pool once you've finished using it
            if (null != jedis) {
                pool.returnResource(jedis);
            }
        }

    }

    public static void addHash() {
        String key = "javapointers";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Java Pointers");
        map.put("domain", "www.javapointers.com");
        map.put("description", "Learn how to program in Java");

        Jedis jedis = pool.getResource();

        try {

            // save to redis
            jedis.hmset(key, map);

            //after saving the data, lets retrieve them to be sure that it has really added in redis
            Map<String, String> stringMap = jedis.hgetAll(key);

            for (Map.Entry<String, String> entry : stringMap.entrySet()) {
                System.out.println("key :: " + entry.getKey() + "  value :: " + entry.getValue());
            }
        } catch (JedisException e) {
            //if something wrong happen, return it back to the pool
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
                jedis = null;
            }
        } finally {
            if (null != jedis) {
                pool.returnResource(jedis);
            }
        }

    }
}
