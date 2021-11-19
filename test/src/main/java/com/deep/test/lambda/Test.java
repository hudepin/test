package com.deep.test.lambda;

import java.util.Date;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-6-3 14:18
 */
public class Test {
    public Test(){
        System.out.println("construct method");
    }
    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };
        run1.run();
        Runnable run2 = ()-> System.out.println(2);
        run2.run();
        Consumer<String> consumer = (X)-> System.out.println(X);
        consumer.accept("有一个参数，无返回值");

        BinaryOperator<Integer> binaryOperator =(x,y)->x+y;
        Integer res = binaryOperator.apply(1,2);
        System.out.println(res);
        System.out.println();
        //supplier 创建对象
        Supplier<Test> supplier = Test::new;
        //get 每次调用get()方法时都会调用构造方法创建一个新对象
        System.out.println(supplier.get());
        Supplier<Integer> supplier1 = ()->(supTest(1,3));
        System.out.println(supplier1.get());
        System.out.println(System.currentTimeMillis());


    }

    public static int supTest(int x,int y){
        return x+y;
    }

}
