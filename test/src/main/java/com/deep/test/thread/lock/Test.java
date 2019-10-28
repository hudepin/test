package com.deep.test.thread.lock;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-23 17:14
 */
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadWait threadWait = new ThreadWait(lock);
        threadWait.start();
        ThreadWait threadWait1 = new ThreadWait(lock);
        threadWait1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadNotify threadNotify = new ThreadNotify(lock);
        threadNotify.start();



    }
}
