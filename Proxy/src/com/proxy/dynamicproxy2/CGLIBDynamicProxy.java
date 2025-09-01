package com.proxy.dynamicproxy2;

public class CGLIBDynamicProxy {
    public static void main(String[] args) {
        //创建代理对象
        SuperStar proxy = CglibProxyFactory.getProxy();

        //通过代理处理信
        proxy.readLetter("粉丝1的信");
        proxy.readLetter("粉丝2的信");
    }
}
