package com.taotao.jedis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/applicationContext*.xml"})
public class TestJedis {

	@Resource(name="redisClient")
	private JedisPool jedisPool;
	
	@Test
	public void testJedis() {
		Jedis jedis = new Jedis("192.168.0.104",6379);
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();
	}

	@Test
	public void testJedisPool(){
		JedisPool pool = new JedisPool("192.168.0.104",6379);
		Jedis jedis = pool.getResource();
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();
		pool.close();
	}
	
	@Test
	public void testJedisPool2(){
		Jedis jedis = jedisPool.getResource();
		String name = jedis.get("name");
		System.out.println("name:"+name);
		jedis.close();
		jedisPool.close();
	}
}
