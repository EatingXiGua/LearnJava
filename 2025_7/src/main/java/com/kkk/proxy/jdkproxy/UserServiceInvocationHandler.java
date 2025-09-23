package com.kkk.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 3.实现调用处理器InvocationHandler
 */
public class UserServiceInvocationHandler implements InvocationHandler {

    private final Object target; // 被代理的真实对象

    public UserServiceInvocationHandler(final Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法执行前增强
        System.out.println("[JDK Proxy] 开始执行方法: " + method.getName());

        // 调用真实对象的方法
        Object result = method.invoke(target, args);

        // 方法执行后增强
        System.out.println("[JDK Proxy] 方法执行完毕: " + method.getName());
        return result;
    }
}
