package com.seckillhigh.controller;


import com.seckillhigh.entity.MiaoshaOrder;
import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.redis.RedisDao;
import com.seckillhigh.redis.keyprefix.GoodsVOKeyPrefix;
import com.seckillhigh.result.CodeMsg;
import com.seckillhigh.service.Impl.MiaoshaGoodsService;
import com.seckillhigh.service.Impl.OrderService;
import com.seckillhigh.service.Impl.MiaoShaService;
import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/miaosha")
public class MiaoShaController implements InitializingBean {


    @Autowired
    MiaoshaGoodsService miaoshaGoodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoShaService miaoShaService;

    @Autowired
    RedisDao<MiaoshaGoodsVo> redisDao;

    static Logger logger = LoggerFactory.getLogger(MiaoShaController.class);

    @RequestMapping("")
    public String miaosha(Model model,
                          @RequestParam("goodsId") long id,
                          SecKillHighUser secKillHighUser) {


        MiaoshaGoodsVo miaoshaGoodsVo = redisDao.getSingleEle(GoodsVOKeyPrefix.goodsVOKeyPrefix, String.valueOf(id));

        if (miaoshaGoodsVo.getStockCount() <= 0) {
            model.addAttribute("errmsg", CodeMsg.OUT_OF_STOCK);
        }

        redisDao.decurByKey(GoodsVOKeyPrefix.goodsVOKeyPrefix, String.valueOf(id));

        long userId = secKillHighUser.getId();

        if (miaoShaService.getOrder(userId, id) != null) {
            model.addAttribute("errmsg", CodeMsg.REPEAT_KILL);
        }




//        MiaoshaGoodsVo miaoshaGoodsVo = miaoshaGoodsService.getMiaoShaGood(id);
//
//        if (miaoshaGoodsVo.getStockCount() <= 0) {
//            model.addAttribute("errmsg", CodeMsg.OUT_OF_STOCK);
//            return "miaosha_fail";
//        }
//
//        long userId = secKillHighUser.getId();
//
//        if (miaoShaService.getOrder(userId, id) != null) {
//            model.addAttribute("errmsg", CodeMsg.REPEAT_KILL);
//        }
//
//        MiaoshaOrder newOrderInfo = miaoShaService.miaosha(userId, id, secKillHighUser, miaoshaGoodsVo);
//
//        model.addAttribute("orderInfo", miaoshaGoodsVo);
//        model.addAttribute("goods", miaoshaGoodsVo);

        return "order_detail";

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        List<MiaoshaGoodsVo> miaoShaGoodsList = miaoshaGoodsService.getMiaoShaGoodsList();

        boolean bool = miaoshaGoodsService.saveGood(miaoShaGoodsList);

        if (!bool) {
            logger.warn("The Redis for miaosha goods is not been cached");
        }

    }
}
