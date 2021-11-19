package com.deep.test.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author hudepin
 * @Description
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：

    线程 A 将调用 zero()，它只输出 0 。
    线程 B 将调用 even()，它只输出偶数。
    线程 C 将调用 odd()，它只输出奇数。
    每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/print-zero-even-odd
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ClassName ZeroEvenOdd
 * @create_date 2020.11.27 09:41
 * @since 1.2.0
 */
public class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            zero.acquire();
            printNumber.accept(0);
            if(i%2==0){
                odd.release();
            }else{
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<n;i=i+2){
            even.acquire();
            printNumber.accept(i+1);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i=i+2){
            odd.acquire();
            printNumber.accept(i+1);
            zero.release();
        }
    }
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        new Thread(()->{
            try {
                zeroEvenOdd.zero(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
