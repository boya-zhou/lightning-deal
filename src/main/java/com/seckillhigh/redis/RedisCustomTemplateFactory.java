package com.seckillhigh.redis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisCustomTemplateFactory<T> {

    public RedisTemplate<String, T> stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, T> redisStringTemplate = new RedisTemplate<>();
        redisStringTemplate.setConnectionFactory(redisConnectionFactory);
        redisStringTemplate.setKeySerializer(new StringRedisSerializer());
        redisStringTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisStringTemplate.afterPropertiesSet();

        return redisStringTemplate;
    }

}
