/**
 * 
 */
package com.deep.test.thread;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author HDP23
 *
 */
public class ExecutorServiceDemo {
	public static void main(String[] args) {
		//固定大小的线程池
		ExecutorService pool =Executors.newFixedThreadPool(1);
		Future<Integer> result = pool.submit(new MyRunable());
		try {
			Object o = result.get();
			System.out.println(""+o);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		pool.submit(new MyRunable());

		pool.shutdown();
		
		//单个线程池
		ExecutorService pool2 = Executors.newSingleThreadExecutor();
		pool2.submit(new MyRunable());
		pool2.submit(new MyRunable());

//		ExecutorService pool3  = Executors.newWorkStealingPool();
//
//		pool3.submit(new MyRunable());
//		pool3.submit(new MyRunable());
//
//
//		ExecutorService pool4 = Executors.newCachedThreadPool();
//
//
//		ExecutorService pool5 = Executors.newScheduledThreadPool(2);


		pool2.shutdown();
	}

}
