package com.seckillhigh.redis;

import com.seckillhigh.redis.keyprefix.KeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDaoImpl<T> implements RedisDao<T> {

    @Autowired
    private RedisCustomTemplateFactory<T> tRedisCustomTemplateFactory;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * Select single element from redis
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    @Override
    public T getSingleEle(KeyPrefix keyPrefix, String key) {

        ValueOperations<String, T> ops;
        ops = this.tRedisCustomTemplateFactory.stringRedisTemplate(redisConnectionFactory).opsForValue();

        return ops.get(keyPrefix.getPrefix() + key);

    }

    /**
     * Save single element in redis
     *
     * @param keyPrefix
     * @param key
     * @param seckillItems
     * @return
     */
    @Override
    public boolean saveSingleEle(KeyPrefix keyPrefix, String key, T seckillItems) {

        ValueOperations<String, T> ops = this.tRedisCustomTemplateFactory.stringRedisTemplate(redisConnectionFactory).opsForValue();

        if (keyPrefix.getTimeOut() <= 0){
            ops.set(keyPrefix.getPrefix() + key, seckillItems);
        }else{
            ops.set(keyPrefix.getPrefix() + key, seckillItems, keyPrefix.getTimeOut(), TimeUnit.SECONDS);
        }

        return true;
    }

    /**
     * @param keyPrefix
     * @param key
     * @return
     */
    @Override
    public boolean incurByKey(KeyPrefix keyPrefix, String key) {
        ValueOperations<String, T> ops = this.tRedisCustomTemplateFactory.stringRedisTemplate(redisConnectionFactory).opsForValue();
        ops.increment(keyPrefix.getPrefix() + key, 1);

        return true;
    }

    /**
     * @param keyPrefix
     * @param key
     * @return
     */
    @Override
    public boolean decurByKey(KeyPrefix keyPrefix, String key) {
        ValueOperations<String, T> ops = this.tRedisCustomTemplateFactory.stringRedisTemplate(redisConnectionFactory).opsForValue();
        ops.increment(keyPrefix.getPrefix() + key, -1);
        return true;
    }

    /**
     * @param keyPrefix
     * @param key
     * @return
     */
    @Override
    public boolean keyExist(KeyPrefix keyPrefix, String key) {
        ValueOperations<String, T> ops = this.tRedisCustomTemplateFactory.stringRedisTemplate(redisConnectionFactory).opsForValue();
        Long size = ops.size(keyPrefix.getPrefix() + key);

        if (size == 0) {
            return false;
        }

        return true;

    }
}
