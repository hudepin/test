package com.deep.test.spring.annotation.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(HelloWorldConfiguration.class) //第一种方式 @Configuration 标注的类
//@Import(HelloWorldImportSelector.class)//第二种方式 实现ImportSelector
@Import(HelloWorldImportBeanDefinitionRegistrar.class)// 第三种方式 实现ImportBeanDefinitionRegistrar
public @interface EnableHello {
}
