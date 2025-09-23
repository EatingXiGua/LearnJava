package com.kkk.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {
    public static void main(String[] args) {
        // 1. 创建真实对象
        UserService target = new UserServiceImpl();

        // 2. 创建InvocationHandler
        InvocationHandler handler = new UserServiceInvocationHandler(target);

        // 3. 创建代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(),   // 实现的接口
                handler                             // 调用处理器
        );

        // 4. 通过代理对象调用方法
        proxy.addUser("张三");
        proxy.deleteUser("李四");
    }
}
