package com.kkk.set;

public class MySet {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",23);
        Student s2 = new Student("zhangsan",23);

        //如果没有重写hashCode方法，不同对象计算出的哈希值是不同的
        //如果重写了hashCode方法，不同对象只要属性值相同，计算出的哈希值就是一样的
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        //在小部分情况下，不同的属性值或者不同的地址值计算出来的哈希值也有可能一样。（哈希碰撞）
        System.out.println("abc".hashCode());//96354
        System.out.println("acD".hashCode());//96354
    }
}
