package com.seckillhigh.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seckillhigh.dao.LegacyDao;
import com.seckillhigh.entity.LegacyItems;
import com.seckillhigh.entity.SecKillHighUser;
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

    @Autowired
    RedisDaoImpl<SecKillHighUser> redisDao;

    @Test
    public void getSingleEle2() {

        System.out.println(redisDao.getSingleEle(SeckillKeyPrefix.token, "497aacbb444e425bb069619dea8d62d1"));
        System.out.println(redisDao.getSingleEle(SeckillKeyPrefix.token, "497aacbb444e425bb069619dea8d62d1").getClass());
    }


    @Test
    public void getSingleEle() {
        redisDaoSecKillItem.saveSingleEle(SeckillKeyPrefix.token, "103", legacyDao.queryItem(103));
        System.out.println(redisDaoSecKillItem.getSingleEle(SeckillKeyPrefix.token, "103").getClass());
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