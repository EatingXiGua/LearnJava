package com.kkk.reflect;

import java.lang.reflect.Field;

public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        /**
         * Class类中用于获取成员变量的方法：
         * - Field[] getFields():返回所有公共成员变量对象的数组
         * - Field[] getDeclaredFields():返回所有成员变量对象的数组
         * - Field getField(String name):返回单个公共成员变量对象
         * - Field getDeclaredField(String name):返回单个成员变量对象
         *
         * Field类中用于创建对象的方法：
         * - void set(Object obj,Object value):赋值
         * - Object get(Object obj):获取值
         */

        Class clazz = Class.forName("com.kkk.reflect.Student");

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        Field gender = clazz.getField("gender");
        System.out.println(gender);

        Field age = clazz.getDeclaredField("age");
        System.out.println(age);

        //获取修饰符
        int modifiers = age.getModifiers();
        System.out.println(modifiers);
        //获取变量名
        String ageName = age.getName();
        System.out.println(ageName);
        //获取变量类型
        Class<?> type = age.getType();
        System.out.println(type);
        //获取变量记录的值
        Student student = new Student("zhangsan",23,"男");
        age.setAccessible(true);//取消权限限制
        int value = (int) age.get(student);
        System.out.println(value);
        //修改变量记录的值
        age.set(student,25);
        System.out.println(student);

    }
}
