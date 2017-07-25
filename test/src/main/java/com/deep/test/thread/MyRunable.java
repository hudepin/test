/**
 * 
 */
package com.deep.test.thread;

/**
 * @author HDP23
 *
 */
public class MyRunable implements Runnable{

	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
	}

}
