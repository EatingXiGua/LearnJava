package com.proxy.dynamicproxy2;

public class SuperStar {
    private String name;

    public SuperStar() {
        this("明星");
    }

    public SuperStar(String name) {
        this.name = name;
    }

    public void readLetter(String letter) {
        System.out.println(name + "读信" + letter);
    }
}
