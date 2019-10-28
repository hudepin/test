package com.deep.test.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-24 10:02
 */
public class ReentrantReadWriteLockDemo {
    static Map<String,Object> cacheMap=new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock read =lock.readLock();
    static Lock write = lock.writeLock();
    public static final Object get(String key) {
        System.out.println("开始读取数据");
        read.lock(); //读锁
        try {
            return cacheMap.get(key);
        }finally {
            read.unlock();
        }
    }
    public static final Object put(String key,Object value){
        write.lock();
        System.out.println("开始写数据");
        try{
            return cacheMap.put(key,value);
        }finally {
            write.unlock();
        }
    }
    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            int finalI = i;
            new Thread(()->{
                ReentrantReadWriteLockDemo.put(finalI +"",finalI);
            }).start();
        }
        for(int i=0;i<1000;i++){

            System.out.println(ReentrantReadWriteLockDemo.get(i+""));
        }
    }
}
