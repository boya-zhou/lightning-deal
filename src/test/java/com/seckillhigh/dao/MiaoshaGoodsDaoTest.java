package com.seckillhigh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest("MainApplication.class")
public class MiaoshaGoodsDaoTest {

    @Autowired
    MiaoshaGoodsDao miaoshaGoodsDao;

    @Test
    public void getMiaoshaGoods() {

        System.out.println(miaoshaGoodsDao.getMiaoshaGoods());

    }

    @Test
    public void getMiaoshaGood() {

        System.out.println(miaoshaGoodsDao.getMiaoshaGood(1));

    }

}