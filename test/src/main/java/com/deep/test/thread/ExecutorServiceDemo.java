/**
 * 
 */
package com.deep.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HDP23
 *
 */
public class ExecutorServiceDemo {
	public static void main(String[] args) {
		//固定大小的线程池
		 ExecutorService pool =Executors.newFixedThreadPool(1);
		pool.submit(new MyRunable());
		pool.submit(new MyRunable());
		
		pool.shutdown();
		
		//单个线程池
		ExecutorService pool2 = Executors.newSingleThreadExecutor();
		pool2.submit(new MyRunable());
		pool2.submit(new MyRunable());
		
		pool2.shutdown();
	}

}
