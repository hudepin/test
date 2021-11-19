package com.deep.test.letcode;

import java.util.Scanner;

/**
 * @author hudepin
 * @Description
 * @ClassName Foo
 * @create_date 2020.09.09 17:49
 * @since 1.2.0
 */
public class Foo {
    public static void main(String[] args) throws InterruptedException {
        String[] arr = args[0].substring(1, args[0].length() - 1).split(",");
        Foo foo = new Foo();
        Task taskA = new Task(foo, Integer.valueOf(arr[0]).intValue());
        Thread threadA = new Thread(taskA);
        threadA.start();
        threadA.join();
        Task taskB = new Task(foo, Integer.valueOf(arr[1]).intValue());
        Thread threadB = new Thread(taskB);
        threadB.start();
        threadB.join();
        Task taskC = new Task(foo, Integer.valueOf(arr[2]).intValue());
        Thread threadC = new Thread(taskC);
        threadC.start();
        threadC.join();


    }

    public void first() {
        print("first");
    }

    public void second() {
        print("second");
    }

    public void third() {
        print("third");
    }

    private void print(String message) {
        System.out.print(message);
    }

//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }

    static class Task implements Runnable {
        private Foo foo;
        private volatile int flag;

        public Task(Foo foo, int flag) {
            this.foo = foo;
            this.flag = flag;
        }

        @Override
        public void run() {
            switch (this.flag) {
                case 1:
                    foo.first();
                    break;
                case 2:
                    foo.second();
                    break;
                case 3:
                    foo.third();
                    break;
            }
        }
    }

}
