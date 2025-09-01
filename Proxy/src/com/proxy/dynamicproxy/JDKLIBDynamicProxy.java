package com.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class JDKLIBDynamicProxy {
    public static void main(String[] args) {
        //创建真实明星
        Star realStar = new RealStar("kun");

        //创建代理实例
        //loader：类加载器，用于加载代理对象
        //interface：被代理类实现的一些接口
        //h：实现了InvocationHandler接口的对象
        Star proxy = (Star) Proxy.newProxyInstance(
                realStar.getClass().getClassLoader(),
                realStar.getClass().getInterfaces(),
                new StarAgentHandler(realStar)
        );

        //通过代理发送信
        proxy.readLetter("粉丝1的信");
        proxy.readLetter("粉丝2的信");
    }
}
