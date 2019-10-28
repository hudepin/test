package com.deep.test.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-24 17:36
 */
public class ThreadParkUpParkTest {
    public static void main(String[] args) {
//        Thread t  = new Thread(()->{
//            System.out.println("Thread park start");
//            //park 进行阻塞当前线程类似于Object wait()
//            LockSupport.park();
//            System.out.println("Thread park end");
//        });
//        t.start();
        Thread t1 = new Thread(new ThreadWait(),"t1");
        Thread t2 = new Thread(new ThreadWait(),"t2");
        t1.start();
        t2.start();
        //unpark进行释放当前线程阻塞 类型与Object notify()
        LockSupport.unpark(t1);
        System.out.println("unpark");

    }
    static class ThreadWait implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"Thread park start");
            //park 进行阻塞当前线程类似于Object wait()
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"Thread park end");
        }
    }
}
