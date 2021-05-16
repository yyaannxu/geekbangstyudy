package com.geekbang.week02;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 折戟沉沙铁未销
 * @version V1.0
 * @date 2021/5/16-2021
 * @Description: 这里用一句话描述这个类的作用
 */
public class HttpClientTest {

    private static final Logger log= LoggerFactory.getLogger(HttpClientTest.class);

    public static void main(String[] args) throws IOException {
        //创建一个client对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建httPost对象
        HttpPost post=new HttpPost("http://localhost:8801");
        //执行
        CloseableHttpResponse response = client.execute(post);
        //获取相应结果
        int statusCode = response.getStatusLine().getStatusCode();
        String context = EntityUtils.toString(response.getEntity(), "UTF-8");
        log.info(context);
    }
}