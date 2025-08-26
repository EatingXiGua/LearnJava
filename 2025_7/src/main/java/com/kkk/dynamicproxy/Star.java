package com.kkk.dynamicproxy;

public interface Star {
    //把所有想要被代理的方法定义在接口当中

    //唱歌
    public abstract String sing(String songName);

    //跳舞
    public abstract void dance();
}
