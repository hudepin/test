package com.deep.test.spring;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * @author hudepin
 * @Description
 * @ClassName Observabledemo
 * @create_date 2020.08.27 09:49
 * @since 1.2.0
 */
public class ObservableDemo {
    public static void main(String[] args) {
        Observable observable = new MyObservable();
        observable.addObserver(new MyObserver());
        observable.notifyObservers("hello, world");

        CommonEvent commonEvent = new CommonEvent("Hello,World");
        MyListiner myListiner = new MyListiner();
        myListiner.onCommonEvent(commonEvent);
    }
    static class MyObservable extends Observable{
        @Override
        public void notifyObservers(Object arg) {
            super.setChanged();
            super.notifyObservers(arg);
            super.clearChanged();
        }
    }
    static class MyObserver implements Observer{

        @Override
        public void update(Observable o, Object message) {
            System.out.printf("observable:%s,message:%s\n",o,message);
        }
    }
    static class CommonEvent extends EventObject{

        /**
         * Constructs a prototypical Event.
         *
         * @param source The object on which the Event initially occurred.
         * @throws IllegalArgumentException if source is null.
         */
        public CommonEvent(Object source) {
            super(source);
        }
    }
    static interface CommonListener<E extends CommonEvent> extends EventListener{
        void onCommonEvent(E event);
    }
    static class MyListiner implements CommonListener{

        @Override
        public void onCommonEvent(CommonEvent event) {
            System.out.println("event:"+event);
        }
    }
}
