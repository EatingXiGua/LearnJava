package com.proxy.dynamicproxy2;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    public static SuperStar getProxy(){
        //创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        //设置被代理类
        enhancer.setSuperclass(SuperStar.class);
        //设置方法拦截器
        enhancer.setCallback(new StarMethodInterceptor());
        //创建代理类
        return (SuperStar)enhancer.create();
    }
}
