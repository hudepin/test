package com.deep.test.spring.annotation;

import java.lang.annotation.*;

/**
 * @author hudepin
 * @Description
 * @ClassName MyComponent2
 * @create_date 2020.09.01 20:42
 * @since 1.2.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponent
public @interface MyComponent2 {
}
