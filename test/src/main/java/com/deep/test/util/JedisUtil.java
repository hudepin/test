package com.deep.test.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @author hudepin
 * @Description
 * @ClassName JedisUtil
 * @create_date 2020.10.26 17:01
 * @since 1.2.0
 */
public class JedisUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JedisUtil.class);
    private static Jedis jedis;
    private static JedisUtil jedisUtil;
    private JedisUtil(){}
    public static synchronized JedisUtil getJedisUtil(){
        if(jedisUtil == null){
            jedisUtil = new JedisUtil();
        }
        return jedisUtil;
    }


    public static void init(String host, int port, String password) {
        jedis = new Jedis(host, port,50000);
        if (StringUtils.isNotEmpty(password)) {
            jedis.auth(password);
        }
    }

    public static boolean flushDb(int db) {
        try {
            if (jedis != null) {
                jedis.select(db);
                jedis.flushDB();
            }
        } catch (Exception e) {
            LOGGER.error("JedisUtil",e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return true;

    }
}
