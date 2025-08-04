package com.kkk.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection2 {
    public static void main(String[] args) {
        //创建集合并添加元素
        Collection<String> coll = new ArrayList<String>();
        coll.add("A");
        coll.add("B");
        coll.add("C");
        coll.add("D");
        //获取迭代器对象
        Iterator<String> iter = coll.iterator();
        //判断当前指向的位置是否有元素
        while (iter.hasNext()) {
            //获取当前指向的元素并移动指针
            String s = iter.next();
            System.out.println(s);
            //迭代器遍历时，不能用集合的方法进行增加或者删除
            if ("A".equals(s)) {
                //coll.remove("A");//这样写是错的，不能用集合的方法 ConcurrentModificationException
                iter.remove();//这样是对的，要用迭代器的方法
            }
        }

        //System.out.println(iter.next());//NoSuchElementException
    }
}
