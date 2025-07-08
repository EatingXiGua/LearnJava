package com.kkk.LearnThread;

import java.util.concurrent.Callable;

// 泛型用来表示要返回的类型
public class MyCallable implements Callable<Integer> {

    // 重写call（是有返回值的，表示多线程运行的结果）
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
