package com.kkk.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {

        //1.filter 过滤
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"张无忌","周芷若","赵敏","张强","张三丰","张翠山","张良","王二麻子","谢广坤");
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //如果返回值为true，表示当前数据留下。false表示舍弃
                return s.startsWith("张");
            }
        }).forEach(s->System.out.println(s));
        //简化为Lambda表达式
        list.stream()
                .filter(s -> s.startsWith("张"))
                .forEach(s-> System.out.println(s));

        //2.limit 获取前几个元素
        //3.skip 跳过前几个元素
        list.stream().limit(3).forEach(s-> System.out.println(s));
        list.stream().skip(3).forEach(s-> System.out.println(s));
        //获取 张强，张三丰，张翠山
        list.stream().skip(3).limit(3).forEach(s-> System.out.println(s));

        System.out.println("---------------------------");
        //4.distinct 元素去重 依赖hashCode方法和equals方法
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"张无忌","张无忌","张无忌","周芷若","赵敏","张强","张三丰");
        list1.stream().distinct().forEach(s-> System.out.println(s));

        System.out.println("---------------------------");
        //5.concat 合并a和b两个流为一个流
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"张翠山","张良","王二麻子","谢广坤");
        Stream.concat(list1.stream(), list2.stream()).distinct().forEach(s-> System.out.println(s));

        System.out.println("---------------------------");
        //6.map 转换流中的数据类型
        ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3,"张无忌-15","周芷若-24","赵敏-13","张强-29","张三丰-100","张翠山-20","张良-30","王二麻子-40","谢广坤-50");
        //只获取里面的年龄并进行打印
        //String->int

        //第一个类型：流中原本的数据类型
        //第二个类型：要转成之后的类型
        //apply的形参s：依次表示流里面的每一个数据
        //返回值：表示转换后的数据
        //注意：当map方法执行完毕后，流上的数据就变成了整数
        //所以在下面forEach当中，s依次表示流里面的每一个数据，这个数据现在就是整数了
        list3.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String[] arr = s.split("-");
                String ageStr = arr[1];
                Integer age = Integer.parseInt(ageStr);
                return age;
            }
        }).forEach(s-> System.out.println(s));

        System.out.println("-------------------------");
        //简化为Lambda表达式
        list3.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(s-> System.out.println(s));

    }
}
