package com.kkk.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

        /**
         * 利用TreeSet存储整数并进行排序
         */
        TreeSet<Integer> set = new TreeSet<>();
        set.add(4);
        set.add(5);
        set.add(1);
        set.add(3);
        set.add(2);

        //直接打印
        System.out.println(set);//[1, 2, 3, 4, 5]

        //遍历
        //迭代器
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }
        //增强for
        for (Integer i : set) {
            System.out.println(i);
        }
        //lambda
        set.forEach(i->System.out.println(i));
    }
}
