package com.kkk.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 2.实现方法拦截器MethodInterceptor
 */
public class UserDaoMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 方法执行前增强
        System.out.println("[CGLib Proxy] 开始执行方法: " + method.getName());

        // 调用父类（即真实目标对象）的方法
        Object result = proxy.invokeSuper(obj, args);

        // 方法执行后增强
        System.out.println("[CGLib Proxy] 方法执行完毕: " + method.getName());
        return result;
    }
}
