package com.seckillhigh.service.Impl;

import com.seckillhigh.dao.MiaoshaGoodsDao;
import com.seckillhigh.redis.RedisDao;
import com.seckillhigh.redis.keyprefix.GoodsVOKeyPrefix;
import com.seckillhigh.redis.keyprefix.PageKeyPrefix;
import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiaoshaGoodsService {

    @Autowired
    MiaoshaGoodsDao miaoshaGoodsDao;

    @Autowired
    RedisDao<String> redisDao;

    @Autowired
    RedisDao<MiaoshaGoodsVo> miaoshaGoodsVoRedisDao;

    @Cacheable(cacheManager = "GenericCacheManager", cacheNames = "redisCache", key = "#root.methodName")
    public List<MiaoshaGoodsVo> getMiaoShaGoodsList() {

        System.out.println("I did not use cache here");
        return miaoshaGoodsDao.getMiaoshaGoods();
    }

    public MiaoshaGoodsVo getMiaoShaGood(long id) {
        return miaoshaGoodsDao.getMiaoshaGood(id);
    }

    @Transactional
    public int decurGoods(long goodsId) {
        int res = miaoshaGoodsDao.decurStock(goodsId);
        return res;
    }

    public String findPage(PageKeyPrefix pagePrefix) {
        return redisDao.getSingleEle(pagePrefix, "");
    }



    public boolean saveGood(List<MiaoshaGoodsVo> miaoShaGoodsList) {
        for (MiaoshaGoodsVo miaoshaGoodsVo : miaoShaGoodsList) {
            miaoshaGoodsVoRedisDao.saveSingleEle(GoodsVOKeyPrefix.goodsVOKeyPrefix,
                    miaoshaGoodsVo.getId().toString(),
                    miaoshaGoodsVo);
        }

        return true;
    }
}
