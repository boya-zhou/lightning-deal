package com.seckillhigh.redis;

import com.seckillhigh.dao.LegacyDao;
import com.seckillhigh.entity.LegacyItems;
import com.seckillhigh.redis.keyprefix.SeckillKeyPrefix;
import com.seckillhigh.redis.keyprefix.UserKeyPrefix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "MainApplication.class")
public class RedisDaoImplTest {

    @Autowired
    RedisDaoImpl<LegacyItems> redisDaoSecKillItem;

    @Autowired
    RedisDaoImpl<Integer> redisDaoInteger;

    @Autowired
    LegacyDao legacyDao;

    @Test
    public void getSingleEle() {
        redisDaoSecKillItem.saveSingleEle(SeckillKeyPrefix.token, "103", legacyDao.queryItem(103));
        System.out.println(redisDaoSecKillItem.getSingleEle(SeckillKeyPrefix.token, "103"));
    }

    @Test
    public void saveEle() {
        redisDaoSecKillItem.saveSingleEle(SeckillKeyPrefix.token, "103", legacyDao.queryItem(103));
    }


    @Test
    public void incurByKey() {
        redisDaoInteger.saveSingleEle(UserKeyPrefix.userId, "103", 10);
        redisDaoInteger.incurByKey(UserKeyPrefix.userId, "103");
    }

    @Test
    public void decurByKey() {
        redisDaoInteger.saveSingleEle(UserKeyPrefix.userId, "103", 10);
        redisDaoInteger.decurByKey(UserKeyPrefix.userId, "103");
    }

    @Test
    public void keyExist() {
        System.out.println(redisDaoInteger.keyExist(UserKeyPrefix.userId, "102"));
        System.out.println(redisDaoInteger.keyExist(UserKeyPrefix.userId, "103"));
    }
}