package com.deep.test.collection.list;

import java.util.function.Consumer;

public interface Iterable<T> {
    Iterator<T> iterator();
//    default void forEach(Consumer<? super T> action){
//        Objects.requireNonNull(action);
//        for(T t : this){
//            action.accept(t);
//        }
//    }


}
