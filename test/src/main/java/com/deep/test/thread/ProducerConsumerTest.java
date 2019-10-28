package com.deep.test.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-23 14:55
 */
public class ProducerConsumerTest {
    class Factory{
        private LinkedBlockingQueue linkedBlockingQueue;
        public void producer(Car car){
            linkedBlockingQueue.offer(car);
        }
        public Car consumer(){
            try {
                return(Car)linkedBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    class Producer implements Runnable{

        @Override
        public void run() {

        }
    }
    class Cosumer implements Runnable{

        @Override
        public void run() {

        }
    }
}
class Car{
    public Car(String name){
        this.name = name;
    }
    private String name;
    private String length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
