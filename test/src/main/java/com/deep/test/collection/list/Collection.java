package com.deep.test.collection.list;


public interface Collection<E> extends Iterable<E>{
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<E> iterator();
    boolean add(E e);
    boolean remove(Object o);
}
