package com.deep.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description:</p>
 * ava的线程分为两种：User Thread(用户线程)、DaemonThread(守护线程)。

 只要当前JVM实例中尚存任何一个非守护线程没有结束，守护线程就全部工作；只有当最后一个非守护线程结束是，守护线程随着JVM一同结束工作，Daemon作用是为其他线程提供便利服务，守护线程最典型的应用就是GC(垃圾回收器)，他就是一个很称职的守护者。

 User和Daemon两者几乎没有区别，唯一的不同之处就在于虚拟机的离开：如果 User Thread已经全部退出运行了，只剩下Daemon Thread存在了，虚拟机也就退出了。 因为没有了被守护者，Daemon也就没有工作可做了，也就没有继续运行程序的必要了。

 首先看一个例子，主线程中建立一个守护线程，当主线程结束时，守护线程也跟着结束。
 * author:hudepin
 * createTime:2019-5-23 14:30
 */
public class DaemoThreadTest {
    public static void main(String[] args) {
        new Thread(()->{
           Thread childThread =  new Thread(()->{
                while(true){
                    System.out.println("I am child Thread");
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            //childThread.setDaemon(true);
            System.out.println(childThread.getContextClassLoader());
            System.out.println(childThread.getThreadGroup());
            childThread.start();

        }).start();
        System.out.println("I am main thread");
    }
}
