package com.deep.test.spring.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author hudepin
 * @Description
 * @ClassName MyComponentScan2
 * @create_date 2020.09.01 20:46
 * @since 1.2.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponentScan
public @interface MyComponentScan2 {
    @AliasFor(annotation = MyComponentScan.class,attribute = "scanBasePackages")
    String[] basePackages() default {};
}
