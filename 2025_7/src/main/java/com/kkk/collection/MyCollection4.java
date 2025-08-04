package com.kkk.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class MyCollection4 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("A");
        coll.add("B");
        coll.add("C");
        coll.add("D");
        //使用匿名内部类
        //底层原理：其实也会遍历集合，依次得到每一个元素（就是s），把得到的每一个元素传递给下面的accept方法。
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //使用lambda表达式进行遍历
        coll.forEach(s -> System.out.println(s));
    }
}
