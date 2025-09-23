package com.kkk.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * 3.创建并使用代理对象
 */
public class CglibProxyDemo  {
    public static void main(String[] args) {
        // 1. 创建Enhancer对象（CGLib的核心类）
        Enhancer enhancer = new Enhancer();

        // 2. 设置父类（即要代理的目标类）
        enhancer.setSuperclass(UserDao.class);

        // 3. 设置回调函数（即我们的方法拦截器）
        enhancer.setCallback(new UserDaoMethodInterceptor());

        // 4. 创建代理对象
        UserDao proxy = (UserDao) enhancer.create();

        // 5. 通过代理对象调用方法
        proxy.addUser("王五");
        proxy.deleteUser("赵六");
    }
}
