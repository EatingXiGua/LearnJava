package com.kkk.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo5 {
    public static void main(String[] args) {
        //collect 收集流中的数据，放到集合中（List Set Map）
        //注意点：如果我们要收集到Map集合中，键不能重复，否则会报错
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"张无忌-男-15","周芷若-女-24","赵敏-女-13","张强-男-29","张三丰-男-100","张翠山-男-20","张良-男-30","王二麻子-男-40","谢广坤-男-50");
        //1.收集到List中 收集所有的男性
        List<String> newList = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(newList);

        //2.收集到set集合(去重) 收集所有男性
        Set<String> newSet = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(newSet);

        //3.收集到map集合 收集所有男性 键：姓名 值：年龄
        Map<String, Integer> newMap = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                /**
                 * toMap：参数一表示键的生成规则 参数二表示值的生成规则
                 * 参数一：
                 *       Function 泛型一：表示流中每一个数据的类型 泛型二：表示Map集合中键的数据类型
                 *       方法apply形参：依次表示流里面的每一个数据
                 *                  方法体：生成键的代码
                 *                  返回值：已经生成的键
                 *
                 * 参数二：
                 *       Function 泛型一：表示流中每一个数据的类型 泛型二：表示Map集合中值的数据类型
                 *       方法apply形参：依次表示流里面的每一个数据
                 *                  方法体：生成值的代码
                 *                  返回值：已经生成的值
                 */
                .collect(Collectors.toMap(
                        new Function<String, String>() {
                            @Override
                            public String apply(String s) {
                                return s.split("-")[0];
                            }
                        },
                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) {
                                return Integer.parseInt(s.split("-")[2]);
                            }
                        }));
        System.out.println(newMap);
        //简化为Lambda表达式
        Map<String, Integer> newMap1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[1])));
    }
}
