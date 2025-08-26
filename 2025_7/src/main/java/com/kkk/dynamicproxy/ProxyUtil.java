package com.kkk.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    /**
     * 给BigStar的对象创建一个代理
     * 形参：被代理的大明星对象 返回值：给大明星对象创建的代理
     * 需求：外面的人想要大明星唱歌
     *      1.获取代理对象
     *          代理对象 = ProxyUtil.createProxy(大明星的对象)
     *      2.调用代理对象的唱歌方法
     *          代理对象.唱歌方法   就会调用下面的invoke方法了
     */

    public static Star createProxy(BigStar bigStar) {
        /**
         * public static Object newProxyInstance(ClassLoader, Class<?>[] interface, InvocationHandler h)
         * 参数一：用于指定用哪个类加载器，去加载生成的代理类
         * 参数二：指定接口，这些接口用于指定生成的代理长什么样，也就是有哪些方法
         * 参数三：用来指定生成的代理对象要干什么事情
         */
        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /**
                         * 参数一：代理的对象
                         * 参数二：要运行的方法
                         * 参数三：调用方法时，传递的实参
                         */
                        if("sing".equals(method.getName())) {
                            System.out.println("准备话筒，收钱");
                        } else if("dance".equals(method.getName())) {
                            System.out.println("准备场地，收钱");
                        }
                        return method.invoke(bigStar, args);
                    }
                }


        );
        return star;
    }
}
