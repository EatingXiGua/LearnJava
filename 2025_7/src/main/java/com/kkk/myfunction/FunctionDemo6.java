package com.kkk.myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.IntFunction;

public class FunctionDemo6 {
    public static void main(String[] args) {
        /**
         * 方法引用 引用数组的构造方法
         * 目的：创建一个指定类型的数组
         * 格式：数据类型[]::new
         * 需求：集合中存储一些整数，收集到数组当中
         *
         * 细节：数组的类型，需要跟流中数据的类型一致
         */

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //收集到数组中 方法引用
        Integer[] array = list.stream().toArray(Integer[]::new);
        System.out.println(array);

        //匿名内部类
        list.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
    }
}
