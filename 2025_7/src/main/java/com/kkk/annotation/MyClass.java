package com.kkk.annotation;


public class MyClass {

    @MyAnnotation(value = "hello",count = 1)
    public void MyMethod() {
        System.out.println("Hello World");
    }
}
