package com.seckillhigh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest("MainApplication.class")
public class GoodsDaoTest {

    @Autowired
    GoodsDao goodsDao;


    @Test
    public void getMiaoshaGoods() {


    }
}