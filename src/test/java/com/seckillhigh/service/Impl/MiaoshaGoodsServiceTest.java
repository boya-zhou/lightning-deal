package com.seckillhigh.service.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest("MainApplication.class")
public class MiaoshaGoodsServiceTest {

    @Autowired
    MiaoshaGoodsService miaoshaGoodsService;

    @Test
    public void getMiaoShaGoodsList() {
        System.out.println(miaoshaGoodsService.getMiaoShaGoodsList());

    }

    @Test
    public void getMiaoShaGood() {
        Assert.notNull(miaoshaGoodsService.getMiaoShaGood(1), "Miaosha iten should not be null");
    }

    @Test
    @Transactional
    @Rollback
    public void decurGoods() {

        int stock = miaoshaGoodsService.getMiaoShaGood(1).getStockCount();
        miaoshaGoodsService.decurGoods(1);
        int afterStock = miaoshaGoodsService.getMiaoShaGood(1).getStockCount();
        assertEquals(stock - 1, afterStock);
    }
}