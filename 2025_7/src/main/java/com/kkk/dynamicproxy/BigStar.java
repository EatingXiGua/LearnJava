package com.kkk.dynamicproxy;

public class BigStar implements Star{
    private String name;

    //唱歌
    @Override
    public String sing(String songName) {
        System.out.println(this.name + "正在唱" + songName);
        return "谢谢";
    }

    //跳舞
    @Override
    public void dance(){
        System.out.println(this.name + "正在跳舞");
    }


    @Override
    public String toString() {
        return "BigStar{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }
}
