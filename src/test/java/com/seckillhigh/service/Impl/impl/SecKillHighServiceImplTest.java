package com.seckillhigh.service.Impl.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "MainApplication.class")
public class SecKillHighServiceImplTest {

    @Autowired
    SecKillHighServiceImpl secKillHighService;

    @Test
    public void queryUser() {
        System.out.println(secKillHighService.queryUser(17192225897L));
    }
}