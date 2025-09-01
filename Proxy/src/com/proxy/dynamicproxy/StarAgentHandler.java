package com.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//3.代理处理器
public class StarAgentHandler implements InvocationHandler {

    private Object target; //被代理的真实对象

    public StarAgentHandler(Object target) {
        this.target = target;
    }

    //负责处理自定义逻辑，当我们的动态代理对象调用一个方法时，这个方法的调用就会被转发到这里
    //proxy：动态生成的代理类
    //method：与代理类对象调用的方法相对应
    //args：当前method方法的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("经纪人接收信");
        //转发给真实明星
        Object result = method.invoke(target, args);
        System.out.println("经纪人记录信处理完成");
        return result;
    }
}
