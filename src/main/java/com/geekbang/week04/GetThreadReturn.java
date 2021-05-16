package com.geekbang.week04;

import java.util.concurrent.FutureTask;

/**
 * @author 折戟沉沙铁未销
 * @version V1.0
 * @date 2021/5/30-2021
 * @Description: 这里用一句话描述这个类的作用
 */
public class GetThreadReturn {
    public static void main(String[] args) throws Exception {
        test1();
        test2();
    }

    public static void test1() throws Exception {
        System.out.println("[1]启动主线程");
        FutureTask futureTask=new FutureTask(new CallAbleThread());
        new Thread(futureTask).start();
        //futureTask.get() 获取返回结果会阻塞在这里。
        Integer result = (Integer) futureTask.get();
        System.out.println("[1]子线程的返回结果为:"+result);
    }

    public static void test2() throws Exception {
        System.out.println("[2]启动主线程");
        RunAbleThread runAbleThread = new RunAbleThread();
        Thread sonThread=new Thread(runAbleThread);
        sonThread.start();
        sonThread.join();
        System.out.println("[2]子线程的返回结果为:"+runAbleThread.getResult());
    }
}