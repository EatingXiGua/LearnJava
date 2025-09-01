package com.proxy.dynamicproxy;



//2.真实明星类
public class RealStar implements Star {
    private String name;

    public RealStar(String name) {
        this.name = name;
    }

    @Override
    public void readLetter(String letter) {
        System.out.println(name + "读信：" + letter);
    }
}
