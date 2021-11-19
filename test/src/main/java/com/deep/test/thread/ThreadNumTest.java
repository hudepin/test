package com.deep.test.thread;

import java.lang.management.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-23 14:13
 */
public class ThreadNumTest {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + info.getThreadName());
        }
        System.out.println(Thread.activeCount());

        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println("loadedClassCount:" + classLoadingMXBean.getLoadedClassCount());
        System.out.println("totalLoadedClassCount: "+classLoadingMXBean.getTotalLoadedClassCount());
        MemoryMXBean memoryMXBean =  ManagementFactory.getMemoryMXBean();
        System.out.println("heapMemoryUsage:" + memoryMXBean.getHeapMemoryUsage());
        System.out.println("nonHeapMemoryUsage:" + memoryMXBean.getNonHeapMemoryUsage());
        while (true){
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
