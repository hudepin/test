/**
 * 
 */
package com.deep.test.thread;

/**
 * @author HDP23
 *
 */
public class Test{
	private int a=1, b=2;

    public void foo(){  // 线程1 
        a=3;
        b=4;
    }

    public int getA(){ // 线程2
        return a;
    }    
    public int getB(){ // 线程2
        return b;
    }
    public static void main(String[] args) {
    	final Test test = new Test();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				test.foo();
				System.out.println("t1:");
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("t2---a:"+test.getA());
				System.out.println("t2---b:"+test.getB());
				
			}
		});
		Thread t3 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("t3---a:"+test.getA());
				System.out.println("t3---b:"+test.getB());
				
				
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}
}
