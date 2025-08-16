package com.kkk.myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo4 {
    public static void main(String[] args) {
        /**
         * 方法引用 构造方法
         *
         * 目的：创建这个类的对象
         *
         * 需求： 集合里面存储姓名和年龄，要求封装成Student对象并收集到List集合中
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,15","周芷若,24","赵敏,13","张强,29","张三丰,100","张翠山,20","张良,30","王二麻子,40","谢广坤,50");
        //String->Student
        List<Student> newList = list.stream().map(new Function<String, Student>() {
            @Override
            public Student apply(String s) {
                String[] arr = s.split(",");
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                return new Student(name, age);
            }
        }).collect(Collectors.toList());
        System.out.println(newList);
        //使用方法引用
        List<Student> newList2 = list.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(newList2);
    }
}
