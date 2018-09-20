package com.seckillhigh.redis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.BeanPostProcessor;


@Component
public class RedisCustomTemplateFactory<T> {

    public RedisTemplate<String, T> stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, T> redisStringTemplate = new RedisTemplate<>();
        redisStringTemplate.setConnectionFactory(redisConnectionFactory);
        redisStringTemplate.setKeySerializer(new StringRedisSerializer());
        redisStringTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisStringTemplate.afterPropertiesSet();

        return redisStringTemplate;
    }


}
