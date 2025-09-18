package com.kkk.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //该注解只能用在方法上
@Retention(RetentionPolicy.RUNTIME) //在运行时保留，可以通过反射获取
public @interface MyAnnotation {
    String value(); //一个元素，没有默认值，使用时必须指定
    int count() default 0; //有默认值，使用时可以省略
}
