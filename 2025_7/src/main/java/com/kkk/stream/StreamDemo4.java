package com.kkk.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "张无忌","周芷若","赵敏","张强","张三丰","张翠山","张良","王二麻子","谢广坤");

        //1.forEach 遍历
        //Consumer的泛型：表示流中数据的类型
        //accept方法的形参s：依次表示流里面的每一个数据
        //方法体：对每一个数据的处理操作
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //简化为Lambda表达式
        list.stream().forEach(s -> System.out.println(s));

        //2.count 统计
        long count = list.stream().count();
        System.out.println(count);

        //3.toArray 收集流中的数据，放到数组中
        //放到Object类型的数组中
        Object[] arr1 = list.stream().toArray();
        System.out.println(Arrays.toString(arr1));

        //IntFunction的泛型：具体类型的数组
        //apply的形参：流中数据的个数，要跟数组的长度保持一致
        //apply的返回值：具体类型的数组
        //方法体：就是创建数组
        //toArray方法的参数的作用：负责创建一个指定类型的数组
        //toArray方法的底层，会依次得到流里面的每一个数据，并把数据放到数组当中
        //toArray方法的返回值：是一个装着流里面所有数据的数组
        String[] arr2 = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(arr2));
        //简化为Lambda表达式
        String[] arr3 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr3));
    }
}
