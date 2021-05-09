package com.geekbang;

import java.lang.reflect.Method;

/**
 * @author 折戟沉沙铁未销
 * @version V1.0
 * @date 2021/5/9-2021
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        //获取class对象
        Class<?> clazz = new MyClassloader().findClass("Hello");
        if(clazz==null){
            System.out.println("classloader加载class对象失败！");
            return;
        }
        //获取class对象中的所有方法，并将方法中的内容设置为可见的
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
        }
        //反射调用方法
        Object object = clazz.getConstructor().newInstance();
        Method hello = clazz.getMethod("hello");
        hello.invoke(object);
    }
}