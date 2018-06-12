package com.seckillhigh.controller;


import com.seckillhigh.entity.MiaoshaOrder;
import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.result.CodeMsg;
import com.seckillhigh.service.Impl.MiaoshaGoodsService;
import com.seckillhigh.service.Impl.OrderService;
import com.seckillhigh.service.Impl.MiaoShaService;
import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/miaosha")
public class MiaoShaController {

    @Autowired
    MiaoshaGoodsService miaoshaGoodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoShaService miaoShaService;

    @RequestMapping("")
    public String miaosha(Model model,
                          @RequestParam("goodsId") long id,
                          SecKillHighUser secKillHighUser) {


        MiaoshaGoodsVo miaoshaGoodsVo = miaoshaGoodsService.getMiaoShaGood(id);

        if (miaoshaGoodsVo.getStockCount() <= 0) {
            model.addAttribute("errmsg", CodeMsg.OUT_OF_STOCK);
            return "miaosha_fail";
        }

        long userId = secKillHighUser.getId();

        if (miaoShaService.getOrder(userId, id) != null) {
            model.addAttribute("errmsg", CodeMsg.REPEAT_KILL);
        }

        MiaoshaOrder newOrderInfo = miaoShaService.miaosha(userId, id, secKillHighUser, miaoshaGoodsVo);

        model.addAttribute("orderInfo", miaoshaGoodsVo);
        model.addAttribute("goods", miaoshaGoodsVo);

        return "order_detail";

    }

}
