package com.deep.test.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName StampedLockTest
 * @create_date 2021.04.01 10:38
 * @since
 */
public class StampedLockTest {
    private static final StampedLock stampedLock = new StampedLock();
    private static Map<String, Object> cache = new HashMap<>();

    public static void main(String[] args) {
        for(int i= 0 ;i<10;i++){
            Thread t = new Thread(()->{
                 cache.put("i","i")  ;
            });

        }

    }

    public static Object get(String key) {
        try {
            stampedLock.tryReadLock();
            return cache.get(key);
        } finally {
            stampedLock.unlockWrite(1L);
        }
    }

    public static void put(String key, String value) {
        try {
            stampedLock.tryWriteLock();
            cache.put(key, value);
        } finally {
            stampedLock.unlockWrite(1L);
        }

    }
}
