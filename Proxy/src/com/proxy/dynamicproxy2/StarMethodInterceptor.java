package com.proxy.dynamicproxy2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("经纪人接收信");
        //转发给真实明星
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("经纪人记录信处理完成");
        return result;
    }
}
