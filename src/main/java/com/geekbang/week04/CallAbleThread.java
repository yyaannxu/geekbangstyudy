package com.geekbang.week04;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author 折戟沉沙铁未销
 * @version V1.0
 * @date 2021/5/30-2021
 * @Description: 这里用一句话描述这个类的作用
 */
public class CallAbleThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = sum();
        return sum;
    }

    private int sum() {
        return fibo(36);
    }

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}