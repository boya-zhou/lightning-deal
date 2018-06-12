package com.seckillhigh.dao;

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
@SpringBootTest()
public class MiaoShaDAOTest {

    @Autowired
    MiaoShaDAO miaoShaDAO;

    @Test
    @Transactional
    @Rollback(value = true)
    public void createAndGetOrder() {

        miaoShaDAO.createOrder(25L, 25L, 33L);
        Assert.notNull(miaoShaDAO.getOrder(25L, 25L));
    }

}