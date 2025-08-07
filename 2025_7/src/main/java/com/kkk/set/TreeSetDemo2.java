package com.kkk.set;

import java.util.TreeSet;

public class TreeSetDemo2 {
    public static void main(String[] args) {

        /**
         * 创建学生集合 然后按照年龄排序
         */

        Student s1 = new Student("zhangsan",23);
        Student s2 = new Student("lisi",24);
        Student s3 = new Student("wangwu",25);

        TreeSet<Student> set = new TreeSet<>();

        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println(set);
    }
}
