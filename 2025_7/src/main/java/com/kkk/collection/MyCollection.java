package com.kkk.collection;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollection {

    public static void main(String[] args) {

        Collection<String> myCollection = new ArrayList<String>();
        //add 添加元素
        //往List系列集合中添加数据，永远返回true，因为List允许重复；往Set集合中添加数据，如果重复会返回false，Set不允许重复
        myCollection.add("Hello");
        myCollection.add("World");
        //remove 清空
        myCollection.clear();
        //remove 删除
        myCollection.add("Hello");
        myCollection.add("World");
        myCollection.add("java");
        myCollection.remove("Hello");
        //contains 判断是否包含  底层是依赖equals方法，所以如果集合中存储的是自定义对象，使用这个方法就需要重写equals方法
        boolean r = myCollection.contains("World");
        System.out.println(r);
        //isEmpty 判断是否为空
        boolean r1 = myCollection.isEmpty();
        System.out.println(r1);
        //size 集合长度
        int size = myCollection.size();
        System.out.println(size);
        System.out.println(myCollection);
    }
}
