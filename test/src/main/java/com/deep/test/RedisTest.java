package com.deep.test;

import com.deep.test.util.JedisUtil;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author hudepin
 * @Description
 * @ClassName RedisTest
 * @create_date 2020.10.26 18:28
 * @since 1.2.0
 */
public class RedisTest {

    private static Integer REDIS_PORT=7380;

    private static String REDIS_HOST ="10.201.130.132";
    // Jedispool
    Jedis jedisCommands;
    JedisPool jedisPool;
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

    private static String REDIS_PASSWORD="redis";
    public RedisTest(){
        // 初始化jedis
        // 设置配置
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(100);
        jedisPoolConfig.setTestOnBorrow(false);//jedis 第一次启动时，会报错
        jedisPoolConfig.setTestOnReturn(true);
        // 初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, REDIS_HOST, REDIS_PORT, 4000,REDIS_PASSWORD,8);
        //
        Jedis jedis = jedisPool.getResource();

        jedisCommands = jedis;
    }
    public void flushDB(int index){
        jedisCommands.flushDB();
    }
    public static void main(String[] args) {
        try {
            RedisTest redisTest = new RedisTest();
            redisTest.flushDB(8);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
