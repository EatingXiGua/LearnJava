package com.kkk.proxy.cglibproxy;

/**
 * 1.目标类 不需要实现接口
 */
public class UserDao {
    public void addUser(String username) {
        System.out.println("添加用户: " + username);
    }

    public void deleteUser(String username) {
        System.out.println("删除用户: " + username);
    }
}
