package com.kkk.generics;

import java.util.Arrays;

/**
 * 写一个类，不确定类型，这个类就可以定义为泛型类
 * @param <E>
 */
public class MyArrayList<E> {
    Object[] obj = new Object[10];
    int size;

    public boolean add(E e) {
        obj[size] = e;
        size++;
        return true;
    }

    public E get(int index) {
        return (E) obj[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
