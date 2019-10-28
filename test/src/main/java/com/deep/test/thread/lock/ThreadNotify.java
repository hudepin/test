package com.deep.test.thread.lock;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-23 17:12
 */
public class ThreadNotify extends Thread{
    private Object lock;
    public ThreadNotify(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            System.out.println("开始执行 thread notify");
            lock.notifyAll();
            System.out.println("执行结束 thread notify");
        }
    }
}
