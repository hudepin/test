package com.deep.test.thread;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName ValatitleTest
 * @create_date 2021.03.24 15:34
 * @since
 */
public class VolatileTest {
    /**
     * volatile 是一个类型修饰符。volatile 的作用是作为指令关键字，确保本条指令不会因编译器的优化而省略
     * 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
     * 禁止进行指令重排序。（实现有序性）
     * volatile 只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性。
     * 关于volatile 原子性可以理解为把对volatile变量的单个读/写，看成是使用同一个锁对这些单个读/写操作做了同步，就跟下面的SoWhat跟SynSoWhat功能类似哦。
     */
    private volatile int i = 1;

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (; ; ) {
            //为什么加锁后就保证了变量的内存可见性了？ 因为当一个线程进入 synchronizer 代码块后，线程获取到锁，会清空本地内存，然后从主内存中拷贝共享变量的最新值到本地内存作为副本，执行代码，又将修改后的副本值刷新到主内存中，最后线程释放锁。
            //这里除了 synchronizer 外，其它锁也能保证变量的内存可见性。
            synchronized (myThread){
                if (myThread.isFlag()) {
                    System.out.println("主线程访问到flag 为 true");
                    break;
                }
            }

        }
    }

    static class MyThread extends Thread {
        public MyThread() {
        }
        //volatile 关键字也能保证可见性
        //使用 volatile 修饰共享变量后，每个线程要操作变量时会从主内存中将变量拷贝到本地内存作为副本，
        // 当线程操作变量副本并写回主内存后，会通过 CPU 总线嗅探机制告知其他线程该变量副本已经失效，
        // 需要重新从主内存中读取。
        //volatile 保证了不同线程对共享变量操作的可见性，也就是说一个线程修改了 volatile 修饰的变量，
        // 当修改后的变量写回主内存时，其他线程能立即看到最新值。
        //总线嗅探机制
        //
        //在现代计算机中，CPU 的速度是极高的，如果 CPU 需要存取数据时都直接与内存打交道，在存取过程中，CPU 将一直空闲，这是一种极大的浪费，所以，为了提高处理速度，CPU 不直接和内存进行通信，而是在 CPU 与内存之间加入很多寄存器，多级缓存，它们比内存的存取速度高得多，这样就解决了 CPU 运算速度和内存读取速度不一致问题。
        //
        //由于 CPU 与内存之间加入了缓存，在进行数据操作时，先将数据从内存拷贝到缓存中，CPU 直接操作的是缓存中的数据。但在多处理器下，将可能导致各自的缓存数据不一致（这也是可见性问题的由来），为了保证各个处理器的缓存是一致的，就会实现缓存一致性协议，而嗅探是实现缓存一致性的常见机制。
        private boolean flag = false;

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag:" + flag);
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }
}
