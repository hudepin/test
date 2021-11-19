package com.deep.test.jdk8;

import com.deep.test.entity.User;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author hudepin
 * @Description
 * @ClassName Test
 * @create_date 2020.09.10 14:59
 * @since 1.2.0
 */
public class Test {
    public static void main(String[] args) {
        String hello="Hello,World";
        handle(t-> System.out.println(t),hello);
        handle(new Handler<String>() {
            @Override
            public void handle(String t) {
                System.out.println(t);
            }
        },hello);
        //Consumer 相对于消费端，接收消息，然后做相应的逻辑处理
        Consumer<String> consumer =  new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("accept:"+s);
            }
        };
        consumer.accept("Hello,World");

        //supplier 相当于一个工厂
        Supplier<Test> supplier = new Supplier() {
            @Override
            public Object get() {
                return new Test();
            }
        };
        Test test = supplier.get();
        //predicate 相当于条件判断if
        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                if("1".equals(o)) return true;
                return false;
            }
        };
        predicate.test("1");

        Predicate predicate1 = new Predicate() {
            @Override
            public boolean test(Object o) {
                return true;
            }
        };
        System.out.println(predicate.and(predicate1));
        //1、构造器方法引用demo
        Function<String,User> function = User::new;//创建一个方法
        System.out.println(function.apply("hudepin"));
        Function<String,User> function1 = (userName)->{return new User(userName);};
        //2、静态方法引用
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("consumer print hello");
        //3、任意对象类的方法引用
        User user = new User("hudepin");


    }
    public static <T> void handle(Handler<T> handle,T t){
        System.out.println("handle before");
        handle.handle(t);
        System.out.println("handle after");
    }

}
