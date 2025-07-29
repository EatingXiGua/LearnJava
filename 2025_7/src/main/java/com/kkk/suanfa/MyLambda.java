package com.kkk.suanfa;

import java.util.Arrays;
import java.util.Comparator;

public class MyLambda {
    /**
     * 注意点：
     * - lambda表达式可以用来简化匿名内部类的书写
     * - lambda表达式只能简化函数式接口的匿名内部类的写法
     * - 函数式接口：
     * - 有且仅有一个抽象方法的接口叫做函数式接口，接口上方可以加@FunctionlInterface
     */
    public static void main(String[] args) {
        //1.利用匿名内部类的形式去调用下面的方法
        //调用一个方法的时候，如果方法的形参是一个接口，那么我们要传递这个接口的实现类对象
        //如果是西安类对象只要用到一次，就可以使用匿名内部类
        method(new Swim() {
            @Override
            public void swimming() {
                System.out.println("swimming");
            }
        });

        //2.利用lambda表达式进行改写
        method(()->{
            System.out.println("swimming");
        });

        //3.lambda省略
        /**
         * 省略规则：
         * - 参数类型可以省略不写
         * - 如果只有一个参数，参数类型可以省略，同时()也可以省略
         * - 如果lambda表达式的方法体只有一行，大括号、分号、return可以省略不写，需要同时省略
         */
        Integer[] arr = {2,3,1,5,6,7,8,4,9};
        //匿名内部类形式
        Arrays.sort(arr,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        //lambda完整格式
        Arrays.sort(arr,(Integer o1, Integer o2)-> {
                return o1-o2;
            }
        );
        //省略写法
        Arrays.sort(arr,( o1,  o2)-> o1 - o2);
        System.out.println(Arrays.toString(arr));
    }

    public static void method(Swim s){
        s.swimming();
    }
}

@FunctionalInterface
interface Swim{
    public abstract void swimming();
}
