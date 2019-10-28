package com.deep.test.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-24 9:55
 */
public class ReentrantLockTest {
    private static int count = 0;
    //true 选择公平锁 fasle选用非公平锁
    static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                LockSupport.park();
                System.out.println("thread-name"+Thread.currentThread().getName()+":"+ReentrantLockTest.inc());
            },"thread-name-"+(i+1));
            t.start();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.interrupt();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("thread-name"+Thread.currentThread().getName()+":"+ReentrantLockTest.inc());
            },"thread2-name-"+(i+6)).start();

        }
    }

    public static int inc() {
        lock.lock();
        try {
            return ++count;
        } finally {
            lock.unlock();
        }
    }
}
