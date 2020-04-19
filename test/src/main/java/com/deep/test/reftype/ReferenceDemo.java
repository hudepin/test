package com.deep.test.reftype;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo {
    static Object stronRef = new Object();

    public static void main(String[] args) throws InterruptedException {
        Object obj =stronRef;
        stronRef = null;
        System.gc();
        System.out.println("gc after:"+obj);
        obj = null;
        System.out.println("gc after:"+obj);
        //只有程序发生oom 异常前才会被回收
        Object softRef = new Object();
        SoftReference sr = new SoftReference(softRef);
        softRef = null;

        System.out.println(sr.get());
        //heap
        //week ref
        Object weekObject = new Object();
        WeakReference weakReference = new WeakReference(weekObject);
        weekObject =null;
        System.gc();
        //弱引用对象没有被引用，发生gc就回收掉
        System.out.println("after:"+weakReference.get());
        Object phantomObject = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        //虚引用
        PhantomReference phantomReference = new PhantomReference(phantomObject,queue);
        System.out.println(phantomReference.get());
        phantomObject = null;
        System.gc();
        System.out.println(phantomReference.get());
        Thread.sleep(200);
        System.out.println(queue.poll());
    }
}
