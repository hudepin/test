package com.deep.test.collection.list;

import java.util.function.Consumer;

/**
 * @author hudepin
 * @Description
 * @ClassName Iterator
 * @create_date 2020.09.14 14:01
 * @since 1.2.0
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
    default void forEachRemaining(Consumer<? super E> consumer){
        while(hasNext()){
            consumer.accept(next());
        }
    }

}
