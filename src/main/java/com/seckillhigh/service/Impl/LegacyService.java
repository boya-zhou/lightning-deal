package com.seckillhigh.service.Impl;

import com.seckillhigh.entity.LegacyItems;
import com.seckillhigh.redis.keyprefix.KeyPrefix;

public interface LegacyService {

    String queryItemName(int id);

    LegacyItems queryItem(KeyPrefix keyPrefix, String key);

    Boolean saveItem(KeyPrefix keyPrefix, String key, LegacyItems legacyItems);
}
