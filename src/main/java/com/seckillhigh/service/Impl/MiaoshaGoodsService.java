package com.seckillhigh.service.Impl;

import com.seckillhigh.dao.MiaoshaGoodsDao;
import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiaoshaGoodsService {

    @Autowired
    MiaoshaGoodsDao miaoshaGoodsDao;

    public List<MiaoshaGoodsVo> getMiaoShaGoodsList(){
        return miaoshaGoodsDao.getMiaoshaGoods();
    }

    public MiaoshaGoodsVo getMiaoShaGood(long id){
        return miaoshaGoodsDao.getMiaoshaGood(id);
    }

    public int decurGoods(long goodsId) {
        int res = miaoshaGoodsDao.decurStock(goodsId);
        return res;
    }
}
