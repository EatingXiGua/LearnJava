package com.kkk.changyongAPI;

import java.util.Objects;

public class ObjectDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

        //toString 返回对象的字符串表示形式
        Object object = new Object();
        String string = object.toString();
        System.out.println(string);

        //equsls 比较两个对象是否相等
        //如果没有重写equals方法，那么默认使用Object中的方法进行比较，比较的是地址值是否相等
        //一般来说地址值对于我们意义不大，所以会重写，重写之后就是比较对象内部的属性值
        Object object2 = new Object();
        boolean result = object2.equals(object);
        System.out.println(result);

        //克隆对象
        //细节：
        //1.重写Object中的clone方法
        //2.让javabean类实现Cloneable接口
        //3.创建原对象并调用clone
        User u1 = new User(1, "John");
        User u2 = (User) u1.clone();
        System.out.println(u1);
        System.out.println(u2);

        //Objects的equals方法
        User u3 = null;
        User u4 = new User(3,"ke");
        boolean r = Objects.equals(u3, u4);
        System.out.println(r);

        //Objects的isNull方法
        System.out.println(Objects.isNull(u3));
        //Objects的nonNull方法
        System.out.println(Objects.nonNull(u3));

    }
}
