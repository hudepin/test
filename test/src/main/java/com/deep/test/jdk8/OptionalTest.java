package com.deep.test.jdk8;

import java.util.Optional;

/**
 * @author hudepin
 * @Description
 * @ClassName OptionalTest
 * @create_date 2020.09.14 10:59
 * @since 1.2.0
 */
public class OptionalTest {
    public static void main(String[] args) throws Exception {
        Optional<String> hello = Optional.of("Hello,world");
        System.out.println(hello.isPresent());//判断Optional 包装的对象是否是空
        hello.ifPresent(s-> System.out.println(s.length()));
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());
        emptyOptional.ifPresent(s-> System.out.println(s.length()));//传入一个consumer，做相应的业务处理
        System.out.println(hello.get());//获取真正的值
        //System.out.println(emptyOptional.get());//没有值会抛出异常
        String orElse = emptyOptional.orElse("orElse Default");
        String orElseGet  = emptyOptional.orElseGet(()->"orElseGet Default");//传入一个supplier，没有值获取supplier提供的默认值
        System.out.println("orElse:"+orElse);
        System.out.println("orElseGet:"+orElseGet);
        String value = emptyOptional.orElseThrow(() -> new Exception("发现空值"));
        //System.out.println(value);
    }
}
