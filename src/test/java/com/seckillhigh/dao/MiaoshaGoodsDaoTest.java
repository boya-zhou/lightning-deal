package com.seckillhigh.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


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

    @Test
    @Transactional
    @Rollback(value = true)
    public void decurStock() {

        int stock = miaoshaGoodsDao.getMiaoshaGood(1).getStockCount();
        int line = miaoshaGoodsDao.decurStock(1);
        int afterStock = miaoshaGoodsDao.getMiaoshaGood(1).getStockCount();
        Assert.assertEquals(stock-1, afterStock);

    }
}