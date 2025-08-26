package com.kkk.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * Class类中用于获取成员方法的方法：
         * - Method[] getMethods():返回所有公共成员方法对象的数组，包括继承的
         * - Method[] getDeclaredMethods():返回所有成员方法对象的数组，不包括继承的
         * - Method getMethod(String name,Class<?>...parameterTypes):返回单个公共成员方法对象
         * - Method getDeclaredMethod(String name,Class<?>...parameterTypes):返回单个成员方法对象
         *
         * Method类中用于创建对象的方法
         * - Object invoke(Object obj,Object... args):运行方法
         * - 参数一：用obj对象调用该方法
         * - 参数二：调用方法的传递的参数（没有则不写）
         * - 返回值：方法的返回值（没有则不写）
         *
         * 获取方法的修饰符
         * 获取方法的名字
         * 获取方法的形参
         * 获取方法的返回值
         * 获取方法抛出的异常
         */

        Class clazz = Class.forName("com.kkk.reflect.Student");

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("-----------------------------");

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("-----------------------------");

        Method m = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(m);
        //获取方法的修饰符
        int modifiers = m.getModifiers();
        System.out.println(modifiers);
        //获取方法的名字
        String name = m.getName();
        System.out.println(name);
        //获取方法的形参
        Parameter[] parameters = m.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        //获取方法抛出的异常
        Class[] exceptionTypes = m.getExceptionTypes();
        for (Class exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }
        //方法运行 获取方法的返回值
        Student s = new Student();
        m.setAccessible(true);
        String r = (String) m.invoke(s, "苹果");
        System.out.println(r);
    }
}
