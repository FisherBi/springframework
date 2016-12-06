package com.fisher.config.database;

import com.fisher.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

	@Bean
	public RedisConnectionFactory redisCF() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory redisCF) {
		RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
		redis.setConnectionFactory(redisCF);
		return redis;
	}
	
}
