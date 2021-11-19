package com.deep.test.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author hudepin
 * @Description
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。

存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。

氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。

这些线程应该三三成组突破屏障并能立即组合产生一个水分子。

你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。

换句话说:

如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
书写满足这些限制条件的氢、氧线程同步代码。

 示例 1:

输入: "HOH"
输出: "HHO"
解释: "HOH" 和 "OHH" 依然都是有效解。
示例 2:

输入: "OOHHHH"
输出: "HHOHHO"
解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 

提示：

输入字符串的总长将会是 3n, 1 ≤ n ≤ 50；
输入字符串中的 “H” 总数将会是 2n 。
输入字符串中的 “O” 总数将会是 n 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/building-h2o
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/building-h2o
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ClassName H2O
 * @create_date 2020.11.27 13:48
 * @since 1.2.0
 */
public class H2O {
    private Semaphore s1 = new Semaphore(2);//H线程信号量
    private Semaphore s2 = new Semaphore(1);
    private Semaphore s3 = new Semaphore(0);
    private Semaphore s4 = new Semaphore(0);
    static class H implements Runnable{
        public H(){}

        @Override
        public void run() {
            System.out.print("H");
        }
    }
    static class O implements Runnable{

        @Override
        public void run() {
            System.out.print("O");
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        s1.acquire();//确保2个线程能进来
        s3.release();//释放H原子到达信号
        s4.acquire();//等等O原子到达
        releaseHydrogen.run();
        s1.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire();
        s4.release(2);
        s3.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        s2.release();
    }

    public static void main(String[] args) throws InterruptedException {
        H2O h2o = new H2O();
        H h = new H();
        Thread t1 = new Thread(h);
        O o = new O();
        Thread t2 = new Thread(o);
        String s = "OOHHHH";
        for(Character c:s.toCharArray()){
            if(c.equals('H')){
                h2o.hydrogen(t1);
            }else if(c.equals('O')){
                h2o.oxygen(t2);
            }
        }

    }
}
