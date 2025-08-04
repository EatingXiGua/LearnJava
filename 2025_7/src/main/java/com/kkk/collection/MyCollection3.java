package com.kkk.collection;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollection3 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("A");
        coll.add("B");
        coll.add("C");
        coll.add("D");
        // 利用增强for进行遍历
        // 注意：str是一个第三方变量，在循环的过程中依次表示集合中的每一个数据
        for (String str : coll) {
            System.out.println(str);
            str = "aaaaa";//这样赋值并不会成功，集合中还是原来的数据
        }
    }
}
