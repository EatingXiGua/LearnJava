package com.kkk.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class MyList2 {
    public static void main(String[] args) {
        /**
         * List集合的遍历方式：
         * - 迭代器遍历
         * - 列表迭代器遍历
         * - 增强for遍历
         * - Lambda表达式遍历
         * - 普通for循环（因为List集合存在索引
         */

        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        //迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //列表迭代器遍历
        //获取一个列表迭代器的对象，里面的指针默认是指向0索引的
        //与迭代器相比，额外添加了一个方法，在遍历的过程中，可以添加元素
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String str = it.next();
            if ("A".equals(str)) {
                it.add("E");
            }
            System.out.println(str);
        }

        //增强for
        for (String s : list) {
            System.out.println(s);
        }

        //lambda表达式遍历
        list.forEach(new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        list.forEach(s -> System.out.println(s));

        //普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
