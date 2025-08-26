package com.kkk.dynamicproxy;

public class Test {
    public static void main(String[] args) {
        /**
         * 需求：外面的人想要大明星唱歌
         *   1.获取代理对象
         *       代理对象 = ProxyUtil.createProxy(大明星的对象)
         *   2.调用代理对象的唱歌方法
         *       代理对象.唱歌方法
         */

        BigStar star = new BigStar("周杰伦");
        Star proxy = ProxyUtil.createProxy(star);
        String r = proxy.sing("晴天");
        System.out.println(r);
    }
}
