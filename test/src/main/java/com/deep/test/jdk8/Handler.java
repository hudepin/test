package com.deep.test.jdk8;

/**
 * @author hudepin
 * @Description
 * @ClassName Handler
 * @create_date 2020.09.10 15:06
 * @since 1.2.0
 */
@FunctionalInterface
public interface Handler<T> {
    void handle(T t);
}
