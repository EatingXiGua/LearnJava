package com.kkk.set;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int age;


    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }


    @Override
    //this：表示当前要添加的元素
    //o：表示已经在红黑树中存在的元素
    //返回值：正数：当前要添加的是小的，存左边；负数：当前要添加的是大的，存右边；0：当前要添加的已经存在，舍弃
    public int compareTo(Student o) {
        System.out.println("----------------");
        System.out.println("this:"+this);
        System.out.println("o:"+o);
        //指定排序的规则 按照年龄排序
        return this.getAge() - o.getAge();
    }
}
