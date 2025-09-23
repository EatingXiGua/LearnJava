package com.kkk.proxy.jdkproxy;

/**
 * 2.实现类（被代理的目标对象）
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(String username) {
        System.out.println("添加用户: " + username);
    }

    @Override
    public void deleteUser(String username) {
        System.out.println("删除用户: " + username);
    }
}
