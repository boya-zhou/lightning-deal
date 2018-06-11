package com.seckillhigh.controller;

import com.seckillhigh.entity.MiaoshaGoods;
import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.exception.GlobalException;
import com.seckillhigh.result.CodeMsg;
import com.seckillhigh.service.Impl.MiaoshaGoodsService;
import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaGoodsService miaoshaGoodsService;

    @RequestMapping("/list")
    public String getMisoshaGoodsList(Model model){

        List<MiaoshaGoodsVo> miaoshaGoodsList = miaoshaGoodsService.getMiaoShaGoodsList();

        model.addAttribute("goodsList", miaoshaGoodsList);

        return "goods_list";

    }

    @RequestMapping("detail/{id}")
    public String getMiaoshaGoodDetail(Model model,
                                       @PathVariable("id") int id,
                                       SecKillHighUser user){



        MiaoshaGoodsVo miaoshaGoodsVo = miaoshaGoodsService.getMiaoShaGood(id);

        if (miaoshaGoodsVo == null){
            throw new GlobalException(CodeMsg.NO_ITEM_ERROR);
        }

        if (user == null){
            return "login";
        }

        model.addAttribute("goods", miaoshaGoodsVo);
        model.addAttribute("user", user);

        return "goods_detail";
    }

}
