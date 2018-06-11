package com.seckillhigh.service.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}