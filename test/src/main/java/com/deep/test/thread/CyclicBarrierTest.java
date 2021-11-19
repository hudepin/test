package com.deep.test.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author hudepin
 * @Description
 * @ClassName CyclicBarrierTest
 * @create_date 2020.11.27 14:02
 * @since 1.2.0
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int threadNum = 2;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }
    static class TaskThread extends Thread{
        private CyclicBarrier barrier;
        public TaskThread(CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
