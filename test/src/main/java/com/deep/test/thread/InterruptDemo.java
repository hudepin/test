package com.deep.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-23 15:52
 */
public class InterruptDemo {
    private volatile static boolean stop=false;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int i=0;
            while(!stop){
                System.out.println("execute"+i++);

            }
        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop=true;
    }
}
