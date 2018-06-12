package com.seckillhigh.controller;

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

        if (user == null){
            return "login";
        }

        MiaoshaGoodsVo miaoshaGoodsVo = miaoshaGoodsService.getMiaoShaGood(id);

        if (miaoshaGoodsVo == null){
            throw new GlobalException(CodeMsg.NO_ITEM_ERROR);
        }

        long startTime = miaoshaGoodsVo.getStartDate().getTime();
        long endTime = miaoshaGoodsVo.getEndDate().getTime();

        long now = System.currentTimeMillis();

        long remainSeconds = 0;

        int miaoshastatus = 0;

        if (now < miaoshastatus){
            miaoshastatus = 0;
            remainSeconds = (startTime - now)/1000;
        }else if(now > endTime){
            miaoshastatus = 2;
            remainSeconds = -1;
        }else{
            miaoshastatus = 1;
        }

        model.addAttribute("miaoshastatus", miaoshastatus);
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("goods", miaoshaGoodsVo);
        model.addAttribute("user", user);

        return "goods_detail";
    }

}
