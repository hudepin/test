package com.deep.test.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hudepin
 * @Description
 * @ClassName ComponentScanDemo
 * @create_date 2020.09.01 20:51
 * @since 1.2.0
 */
@MyComponentScan2(basePackages = "com.deep.test.spring.annotation")
public class ComponentScanDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentScanDemo.class);
        context.refresh();
        TestClass testClass = context.getBean(TestClass.class);
        System.out.println("testClass:"+testClass);
        context.close();
    }
}
