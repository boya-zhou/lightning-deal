package com.seckillhigh.service.Impl;

import com.seckillhigh.dao.LegacyDao;
import com.seckillhigh.entity.LegacyItems;
import com.seckillhigh.redis.keyprefix.KeyPrefix;
import com.seckillhigh.redis.RedisDaoImpl;
import com.seckillhigh.service.Impl.LegacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegacyServiceImpl implements LegacyService {
    @Autowired
    LegacyDao legacyDao;

    @Autowired
    RedisDaoImpl<LegacyItems> redisDaoImpl;

    @Override
    public String queryItemName(int id) {
        return legacyDao.queryItemName(id);
    }

    @Override
    public LegacyItems queryItem(KeyPrefix keyPrefix, String key) {

        return redisDaoImpl.getSingleEle(keyPrefix, key);
    }

    @Override
    public Boolean saveItem(KeyPrefix keyPrefix, String key, LegacyItems legacyItems) {
        return redisDaoImpl.saveSingleEle( keyPrefix,  key, legacyItems);
    }
}
