package com.deep.test;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-23 16:57
 */
public class lock {
    public static volatile boolean stop;
    public static void main(String[] args) {
        synchronized (lock.class){
            System.out.println(12);
        }
    }
    public synchronized void syncTest(){
        System.out.println("method sync");
    }
}
