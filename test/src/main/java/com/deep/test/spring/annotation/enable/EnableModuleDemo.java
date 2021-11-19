package com.deep.test.spring.annotation.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hudepin
 * @Description
 * @ClassName EnableModuleDemo
 * @create_date 2020.09.01 20:55
 * @since 1.2.0
 */
@EnableHello
public class EnableModuleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableModuleDemo.class);
        context.refresh();
        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println(helloWorld);
        context.close();
    }
}
