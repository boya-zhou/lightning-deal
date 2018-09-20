package com.seckillhigh.service.Impl;

import com.seckillhigh.dao.MiaoShaDAO;
import com.seckillhigh.entity.MiaoshaOrder;
import com.seckillhigh.entity.OrderInfo;
import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MiaoShaService {


    @Autowired
    MiaoshaGoodsService miaoshaGoodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoShaDAO miaoShaDAO;


    @Transactional
    public MiaoshaOrder miaosha(long userId, long goodsId, SecKillHighUser secKillHighUser, MiaoshaGoodsVo miaoshaGoodsVo){

        miaoshaGoodsService.decurGoods(goodsId);

        int res = orderService.createOrder(userId, goodsId, miaoshaGoodsVo);

        OrderInfo orderInfo = orderService.getOrderInfo(userId, goodsId);

        int bool = miaoShaDAO.createOrder(userId, goodsId, orderInfo.getId());

        MiaoshaOrder miaoshaOrder = miaoShaDAO.getOrder(userId, goodsId);

        return miaoshaOrder;
    }

    public MiaoshaOrder getOrder(long userId, long goodsId){
        MiaoshaOrder miaoshaOrder = miaoShaDAO.getOrder(userId, goodsId);
        return miaoshaOrder;
    }
}
