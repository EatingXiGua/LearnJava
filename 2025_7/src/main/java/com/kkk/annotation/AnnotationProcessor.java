package com.kkk.annotation;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        //获取MyClass的方法
        for (Method method : MyClass.class.getDeclaredMethods()) {
            //检查方法上是否有MyAnnotation注解
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                //获取注解实例
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Annotation: " + annotation.value());
                System.out.println("Annotation Value: " + annotation.value());
            }
        }
    }
}
