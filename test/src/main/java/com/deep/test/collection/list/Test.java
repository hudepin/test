package com.deep.test.collection.list;

import java.util.List;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * @author hudepin
 * @Description list split 多线程处理  list并行执行处理
 * @ClassName Test
 * @create_date 2020.09.14 14:25
 * @since 1.2.0
 */
public class Test {
    private static AtomicInteger count = new AtomicInteger(0);
    private static  InheritableThreadLocal<Spliterator> spliterator = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        List<String> strList = createList();
        Spliterator spliterator1 = strList.spliterator();
        spliterator.set(spliterator1);
        for(int i=0;i<4;i++){
            new MyThread().start();
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结果为：" + count);
    }

    private static List<String> createList() {
        List<String> result = new ArrayList<>();
        for(int i=0; i<100; i++){
            if(i % 10 == 0){
                result.add(i+"");
            }else{
                result.add("aaa");
            }
        }
        return result;
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("线程"+threadName+"开始运行-----");
            spliterator.get().trySplit().forEachRemaining(new Consumer() {
                @Override
                public void accept(Object o) {
                    if(isInteger((String)o)){
                        int num = Integer.parseInt(o +"");
                        count.addAndGet(num);
                        System.out.println("数值："+num+"------"+threadName);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            System.out.println("线程"+threadName+"运行结束-----");
        }
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
