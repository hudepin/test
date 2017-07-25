/**
 * 
 */
package com.deep.test.thread;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HDP23
 *
 */
public class ConcurrentLinkedQueueTest {
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static int count =2;//线程数
	private static CountDownLatch cdl = new CountDownLatch(count);
	
	public static void offer(){
		for(int i=0;i<100000;i++) queue.offer(i);
	}
	
	static class Poll implements Runnable{
		public void run(){
			while(!queue.isEmpty()){
				System.out.println(queue.poll());
			}
			cdl.countDown();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		long timeStart = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		for(int i=0;i<count;i++){
			es.submit(new Poll());
		}
		cdl.await();
		System.out.println("cost time "+(System.currentTimeMillis()-timeStart));
		es.shutdown();
	}

}
