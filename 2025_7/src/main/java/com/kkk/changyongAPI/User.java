package com.kkk.changyongAPI;

//Cloneable
//如果一个接口里面没有抽象方法
//表示当前的接口是一个标记性接口
//实现Cloneable接口，当前类的对象就可以被克隆
public class User implements Cloneable{
    private int id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //调用父类中的clone方法
        //相当于让java帮我们克隆一个对象，并把克隆的对象返回出去
        return super.clone();
    }
}
