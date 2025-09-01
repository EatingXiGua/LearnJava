package com.proxy.staticproxy;

//4.使用示例
public class StaticProxy {
    public static void main(String[] args) {
        //创建真实明星
        Star kun = new RealStar("kun");

        //创建代理(经纪人)
        Star agent = new StarAgent(kun);

        //粉丝通过经纪人送信
        agent.readLetter("粉丝1的信");
        agent.readLetter("粉丝2的信");
    }
}
