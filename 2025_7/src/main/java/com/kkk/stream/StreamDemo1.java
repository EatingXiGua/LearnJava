package com.kkk.stream;

import java.util.ArrayList;

public class StreamDemo1 {
    public static void main(String[] args) {
        /**
         * 创建集合添加元素，完成需求：
         * 1.把所有张开头的元素存储到新集合中
         * 2.把所有张开头的长度为3的元素存到新集合中
         * 3.遍历打印最终结果
         */
        ArrayList<String> list = new ArrayList<String>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //常规做法
        //1.把所有张开头的元素存储到新集合中
        ArrayList<String> list1 = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                list1.add(name);
            }
        }
        //2.把所有张开头的长度为3的元素存到新集合中
        ArrayList<String> list2 = new ArrayList<>();
        for (String name : list1) {
            if (name.length()==3){
                list2.add(name);
            }
        }
        //3.遍历打印最终结果
        for (String name : list2) {
            System.out.println(name);
        }

        //Stream流
        list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length()==3).forEach(name -> System.out.println(name));
    }
}
