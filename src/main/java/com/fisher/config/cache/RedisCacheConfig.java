package com.fisher.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by fisbii on 16-12-6.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig {
    @Bean
    public CacheManager redisCacheManager(RedisTemplate redisCacheTemplate){
        return new RedisCacheManager(redisCacheTemplate);
    }
    @Bean
    public JedisConnectionFactory redisCacheConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
    @Bean
    public RedisTemplate<String,String> redisCacheTemplate(RedisConnectionFactory redisCacheConnectionFactory){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisCacheConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
