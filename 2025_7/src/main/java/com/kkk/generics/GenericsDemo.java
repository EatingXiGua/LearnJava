package com.kkk.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
        /**
         * 泛型不具备继承性，但是数据具备继承性
         */

        //创建集合的对象
        ArrayList<Ye> list1 = new ArrayList<>();
        ArrayList<Fu> list2 = new ArrayList<>();
        ArrayList<Zi> list3 = new ArrayList<>();

        //泛型不具备继承性
        //调用method方法
        method(list1);
        //method(list2);//报错，不能传ArrayList<Fu>类型
        //method(list3);//报错，不能传ArrayList<Zi>类型

        //但是数据具有继承性
        //ArrayList<Ye>列表中添加Fu和Zi都是可以的
        list1.add(new Ye());
        list1.add(new Fu());
        list1.add(new Zi());

        //调用method1方法
        method1(list1);
        method1(list2);
        method1(list3);
    }


    /**
     * 此时，泛型中写的是什么类型，那么只能传递什么类型的数据
     * @param list
     */
    public static void method(ArrayList<Ye> list) {

    }

    /**
     * 利用泛型方法解决method方法存在的问题。但是这种写法可以接收任意类型的数据，这样也不好。
     * @param list
     * @param <E>
     */
    public static<E> void method1(ArrayList<E> list) {

    }

    /**
     * 使用泛型的通配符解决
     * ? 表示不确定的类型
     * ? extends E：表示可以传递E或者E所有的子类类型
     * ? super E：表示可以传递E或者E所有的父类类型
     *
     * 应用场景：
     *          1.如果我们在定义类、方法、接口的时候，如果类型不确定，就可以定义泛型类、泛型方法、泛型接口
     *          2.如果类型不确定，但是能知道以后只能传递某个继承体系中的，就可以使用泛型的通配符
     *
     * 泛型的通配符：
     *          关键点：可以限定类型的范围
     */
    public static void method2(ArrayList<?> list) {}//?跟E差不多，区别是钱买你修饰符后面不用写
    public static void method3(ArrayList<? extends Ye> list) {}
}

class Ye {}
class Fu extends Ye {}
class Zi extends Fu {}