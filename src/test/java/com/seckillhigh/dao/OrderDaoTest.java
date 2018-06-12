package com.seckillhigh.dao;

import com.seckillhigh.entity.OrderInfo;
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
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    @Transactional
    @Rollback(value = true)
    public void createAndGetOrder() {

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(35L);
        orderInfo.setGoodsId(25L);
        orderDao.createOrder(orderInfo);
        Assert.notNull(orderDao.getOrder(35L, 25L));
        System.out.println(orderDao.getOrder(35L, 25L));
    }
}