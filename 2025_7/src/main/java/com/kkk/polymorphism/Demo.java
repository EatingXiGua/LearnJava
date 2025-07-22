package com.kkk.polymorphism;

public class Demo {
    public static void main(String[] args) {
        Animal animal = new Dog();
        //调用成员变量：编译看左边，运行也看左边
        //编译看左边：javac编译代码时，会看左边的父类中有没有这个变量，如果有，编译成功，没有则编译失败
        //运行也看左边：java运行代码的时候，实际获取的就是左边父类成员变量的值
        System.out.println(animal.name); // 打印animal
        //调用成员方法：编译看左边，运行看右边
        //编译看左边：javac编译代码时，会看左边的父类中有没有这个方法，如果有，编译成功，没有则编译失败
        //运行看右边：java运行代码的时候，实际上运行的是子类中的方法
        animal.show();//打印Dog -- show

        //理解：
        //Animal animal = new Dog();
        //现在用animal区调用变量和方法
        //animal是Animal类型，所以默认都会从Animal这个类中去找
        //成员变量：在子类的对象中，会继承父类的成员变量
        //成员方法：子类重写了方法，现在虚方法表中是会把父类的方法覆盖
    }
}

class Animal {
    String name = "Animal";
    public void show(){
        System.out.println("Animal --- show");
    }
}

class Dog extends Animal {
    String name = "Dog";

    @Override
    public void show(){
        System.out.println("Dog -- show");
    }
}

class Cat extends Animal {
    String name = "Cat";

    @Override
    public void show(){
        System.out.println("Cat -- show");
    }
}
