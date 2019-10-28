package com.deep.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-23 10:23
 */
public class ThreadStatus {
    public static void main(String[] args) {
        //time wating
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("time-wating");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"time-wating").start();
        new Thread(()->{
            while(true){
                synchronized (ThreadStatus.class){
                    try {
                        ThreadStatus.class.wait();
                        System.out.println("1212");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        },"wating").start();
        System.out.println("end");
        new Thread(new BlockedDemo(),"block-1").start();
        new Thread(new BlockedDemo(),"block-2").start();
    }
    static class BlockedDemo extends Thread{
        public void run(){
            synchronized (BlockedDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
