package com.kkk.myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class FunctionDemo3 {
    public static void main(String[] args) {
        /**
         * 方法引用
         * 引用成员方法
         * 需求：
         *  集合中有一些名字，按照要求过滤 以张开头，而且名字三个字
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        //常规方法
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(System.out::println);
        //匿名内部类
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length()==3;
            }
        }).forEach(System.out::println);
        //方法引用 其他类
        list.stream().filter(new StringOperation()::stringJudge).forEach(System.out::println);
        //方法引用 本类
        //静态方法中是没有this的，直接这样写会报错list.stream().filter(this::stringJudge1).forEach(System.out::println);
        list.stream().filter(new FunctionDemo3()::stringJudge1).forEach(System.out::println);//这时候跟 其他类方法调用没有区别
    }


    public boolean stringJudge1(String s) {
        return s.startsWith("张") && s.length()==3;
    }
}
