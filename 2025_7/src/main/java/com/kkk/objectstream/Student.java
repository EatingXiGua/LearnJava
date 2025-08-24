package com.kkk.objectstream;

import java.io.Serial;
import java.io.Serializable;

/*
Serializable接口里面没有抽象方法，称为标记型接口
实现这个接口，表示当前的类可以被序列化
 */
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 6849740451379694236L;

    private String name;
    private int age;

    //transient:瞬态关键字
    //作用：不会把当前属性序列化到本地文件当中
    private transient int grade;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
}
