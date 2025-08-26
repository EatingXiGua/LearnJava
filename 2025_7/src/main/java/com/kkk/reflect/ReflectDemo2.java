package com.kkk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /**
         * Class类中用于获取构造方法的方法：
         * - Contructor<?>[] getContructors()：返回所有公共构造方法对象的数组
         * - Contructor<?>[] getDeclaredContructors()：返回所有构造方法对象的数组
         * - Contructor<T> getContructor(Class<?>... parameterTypes)：返回单个公共构造方法对象
         * - Contructor<T> getDeclaredContructor(Class<?>... parameterTypes)：返回单个构造方法对象
         *
         * Constructor类中用于创建对象的方法：
         * - T newInstance(Object... initargs)：根据指定的构造方法创建对象
         * - setAccessible(boolean flag)：设置为true，表示取消访问检查
         */

        //获取class字节码文件对象
        Class clazz = Class.forName("com.kkk.reflect.Student");
        //获取构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //获取权限修饰符
        int modifiers = constructor.getModifiers();
        System.out.println(modifiers);
        //获取参数
        Parameter[] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        //创建对象
        Object zhangsan = constructor.newInstance("zhangsan ", 21);
        System.out.println(zhangsan);
    }
}
