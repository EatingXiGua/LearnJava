package com.proxy.staticproxy;

//3.经纪人类（代理）
//将目标对象注入代理类，在代理类中调用对应的目标类中的目标方法
public class StarAgent implements Star{
    private Star star;

    public StarAgent(Star star) {
        this.star = star;
    }

    @Override
    public void readLetter(String letter) {
        System.out.println("经纪人接收信");
        star.readLetter(letter);//明星读信
        System.out.println("经纪人记录信处理完成");
    }
}
