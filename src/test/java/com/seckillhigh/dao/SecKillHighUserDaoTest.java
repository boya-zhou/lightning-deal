package com.seckillhigh.dao;

import com.seckillhigh.entity.SecKillHighUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest("MainApplication.class")
public class SecKillHighUserDaoTest {

    @Autowired
    SecKillHighUserDao secKillHighUserDao;

    @Test
    public void queryUser() {
        System.out.println(secKillHighUserDao.queryUser(17192225897L));
    }
}