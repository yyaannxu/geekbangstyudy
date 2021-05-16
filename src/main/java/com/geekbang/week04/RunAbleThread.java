package com.geekbang.week04;

/**
 * @author 折戟沉沙铁未销
 * @version V1.0
 * @date 2021/5/30-2021
 * @Description: 这里用一句话描述这个类的作用
 */
public class RunAbleThread implements Runnable {

    private int result;

    @Override
    public void run() {
        int sum = sum();
        result=sum;
    }

    private int sum() {
        return fibo(36);
    }

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public int getResult() {
        return result;
    }
}