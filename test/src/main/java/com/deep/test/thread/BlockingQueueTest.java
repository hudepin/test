/**
 * 
 */
package com.deep.test.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author HDP23
 *
 */
public class BlockingQueueTest {
	class Basket {
		BlockingQueue<String> bq = new LinkedBlockingQueue<String>();

		public void produce() throws InterruptedException {
			bq.put("苹果一个");
		}

		public String consume() throws InterruptedException {
			return bq.take();
		}
	}

	class Producer implements Runnable {
		private Basket basket;
		private String instance;

		public Producer(Basket basket, String instance) {
			this.basket = basket;
			this.instance = instance;
		}

		public void run() {
			while(true){
				try {
					System.out.println("----------开始生产苹果"+instance);
					basket.produce();
					System.out.println("----------结束生产苹果"+instance);
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}
	class Consumer implements Runnable{
		private Basket basket;
		private String instance;

		public Consumer(Basket basket, String instance) {
			this.basket = basket;
			this.instance = instance;
		}

		public void run() {
			while(true){
				try {
					System.out.println("*********开始消费苹果"+instance);
					System.out.println(basket.consume());
					System.out.println("*********结束消费苹果"+instance);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
	public static void main(String[] args) {
		BlockingQueueTest bq = new BlockingQueueTest();
		Basket basket = bq.new Basket();
		ExecutorService pool =  Executors.newCachedThreadPool();
		Producer producer =bq.new Producer(basket, "producer1");
		Producer producer2 =bq.new Producer(basket, "producer2");
		Consumer consumer = bq.new Consumer(basket, "consumer1");
		pool.submit(producer);
		pool.submit(producer2);
		pool.submit(consumer);
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pool.shutdown();
	}

}
