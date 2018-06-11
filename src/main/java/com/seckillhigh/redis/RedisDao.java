package com.seckillhigh.redis;

import com.seckillhigh.redis.keyprefix.KeyPrefix;

public interface RedisDao<T> {

    T getSingleEle(KeyPrefix keyPrefix, String key);

    boolean saveSingleEle(KeyPrefix keyPrefix, String key, T item);

    boolean keyExist(KeyPrefix keyPrefix, String key);

    boolean incurByKey(KeyPrefix keyPrefix, String key);

    boolean decurByKey(KeyPrefix keyPrefix, String key);

}
