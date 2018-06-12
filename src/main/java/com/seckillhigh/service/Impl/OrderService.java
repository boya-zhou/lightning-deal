package com.seckillhigh.service.Impl;

import com.seckillhigh.dao.OrderDao;
import com.seckillhigh.entity.OrderInfo;
import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public OrderInfo getOrderInfo(long userId, long goodsId) {
        // TODO

        OrderInfo orderInfo = orderDao.getOrder(userId, goodsId);

        return orderInfo;
    }

    public int createOrder(long userId, long goodsId, SecKillHighUser secKillHighUser, MiaoshaGoodsVo miaoshaGoodsVo) {

        OrderInfo orderInfo = new OrderInfo();

        orderInfo.setUserId(userId);
        orderInfo.setGoodsId(goodsId);
        orderInfo.setGoodsName(miaoshaGoodsVo.getGoodsName());
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsPrice(miaoshaGoodsVo.getGoodsPrice());
        orderInfo.setStatus(0);
        orderInfo.setCreateDate(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));

        int bool = orderDao.createOrder(orderInfo);

        return bool;
    }
}
