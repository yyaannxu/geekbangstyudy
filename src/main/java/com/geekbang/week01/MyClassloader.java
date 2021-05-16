package com.geekbang.week01;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 折戟沉沙铁未销
 * @version V1.0
 * @date 2021/5/9-2021
 * @Description: 这里用一句话描述这个类的作用
 */
public class MyClassloader extends ClassLoader {

    /**
     * 查找指定的文件并加载对应的class对象
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            //读取resource目录下面的文件内容
            String replaceName = name.replace(".", "/");
            String file = replaceName + ".xlass";
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
            BufferedInputStream buf=new BufferedInputStream(inputStream);
            byte[] data = new byte[buf.available()];
            buf.read(data);
            buf.close();
            //进行解码
            for (int i = 0; i < data.length; i++) {
                data[i]= (byte) (255 - data[i]);
            }
            return defineClass(name,data,0,data.length);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}