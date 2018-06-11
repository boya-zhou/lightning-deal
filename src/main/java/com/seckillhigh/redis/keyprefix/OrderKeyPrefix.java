package com.seckillhigh.redis.keyprefix;

import com.seckillhigh.redis.keyprefix.BaseKeyPrefix;

public class OrderKeyPrefix extends BaseKeyPrefix {

    public OrderKeyPrefix(String prefix) {
        super(prefix);
    }

    public OrderKeyPrefix(int timeOut, String prefix) {
        super(timeOut, prefix);
    }
}
