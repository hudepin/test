/**
 * 
 */
package com.deep.test.thread;

import java.util.concurrent.Callable;

/**
 * @author HDP23
 *
 */
public class MyRunable implements Callable{

	@Override
	public Integer call() throws Exception {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		return 4;
	}
}
