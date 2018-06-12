package com.seckillhigh.dao;

import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.utils.Md5;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SecKillHighUserDaoTest {

    @Autowired
    SecKillHighUserDao secKillHighUserDao;

    @Test
    public void queryUser() {
        System.out.println(secKillHighUserDao.queryUser(17192225897L));
    }

    @Test
    @Transactional
    @Rollback
    public void insertUser() {

        int before = secKillHighUserDao.countTable();

        SecKillHighUser user = new SecKillHighUser();
        user.setSalt("1a2b3d4b");
        user.setPassword(Md5.inputPassToDB("chimantou", user.getSalt()));

        secKillHighUserDao.insertUser(user);

        int after = secKillHighUserDao.countTable();

        Assert.assertEquals(before + 1, after);

    }
}