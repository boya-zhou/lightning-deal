package com.seckillhigh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest("MainApplication.class")
public class LegacyDaoTest {

    @Autowired
    LegacyDao legacyDao;

    @Test
    public void queryItem() {
        System.out.println(legacyDao.queryItemName(103));
    }
}