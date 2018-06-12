package com.seckillhigh.service.Impl;

import com.seckillhigh.dao.MiaoShaDAO;
import com.seckillhigh.entity.OrderInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoShaServiceTest {

    @Mock
    OrderService orderService;

    @Mock
    @Autowired
    MiaoShaDAO miaoShaDAO;

    @InjectMocks
    MiaoShaService miaoShaService;

//    @Test
//    @Transactional
//    @Rollback
//    public void miaosha() {
//        when(orderService.getOrderInfo(1, 1)).thenReturn(new OrderInfo(1L, 1L, 1L));
//        Assert.notNull(miaoShaService.miaosha(1, 1, , ), "miaosha should not be null");
//
//    }

    @Test
    @Transactional
    @Rollback
    public void getMiaoShaOrder(){
        miaoShaDAO.createOrder(1,1,1);
        Assert.notNull(miaoShaDAO.getOrder(1,1));
    }


}