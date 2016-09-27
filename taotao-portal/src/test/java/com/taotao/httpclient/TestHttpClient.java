package com.taotao.httpclient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.util.Log4jConfigurer;

public class TestHttpClient {
	
	static{
		try {
			Log4jConfigurer.initLogging("classpath:properties/log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("初始化log4j配置文件失败");
		}
	}
	
	private static Logger log = Logger.getLogger(TestHttpClient.class);

	@Test
	public void testGetMethod() throws ClientProtocolException, IOException {
		
		
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建get对象
		HttpGet get = new HttpGet("http://www.baidu.com");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//获取响应结果
		log.info("响应码："+response.getStatusLine().getStatusCode());
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity);
		log.info("响应内容："+string);
		response.close();
		httpClient.close();
	}
	
	@Test
	public void testGetMethodWithParam() throws URISyntaxException, ClientProtocolException, IOException{
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建get对象
		URIBuilder uriBuilder = new URIBuilder("http://www.baidu.com/s");
		uriBuilder.addParameter("wd", "java");
		URI uri = uriBuilder.build();
		HttpGet get = new HttpGet(uri);
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//获取响应结果
		log.info("响应码："+response.getStatusLine().getStatusCode());
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity);
		log.info("响应内容："+string);
		response.close();
		httpClient.close();
	}
	
	@Test
	public void testPostMethod() throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建POST对象
		HttpPost post = new HttpPost("http://localhost:8083/post/test.do");
		
		CloseableHttpResponse response = httpClient.execute(post);
		log.info("响应内容:"+EntityUtils.toString(response.getEntity()));
		response.close();
		httpClient.close();
	}

}
