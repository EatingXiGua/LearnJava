package com.kkk.reflect;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 获取class对象的三种方式
         * 1.Class.forName("全类名");
         * 2.类名.class
         * 3.对象.getClass();
         */

        //1.Class.forName("全类名");
        Class clazz = Class.forName("com.kkk.reflect.Student");
        System.out.println(clazz);

        //2.类名.class
        Class clazz2 = Student.class;
        System.out.println(clazz2);

        //3.对象.getClass();
        Student student = new Student();
        Class clazz3 = student.getClass();
        System.out.println(clazz3);
    }
}
