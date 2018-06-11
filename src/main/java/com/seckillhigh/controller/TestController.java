package com.seckillhigh.controller;

import com.seckillhigh.result.CodeMsg;
import com.seckillhigh.result.Result;
import com.seckillhigh.service.Impl.LegacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class TestController {

    @Autowired
    LegacyService legacyService;

    @RequestMapping("/")
    @ResponseBody
    Result<String> home(){
        return new Result<String>(CodeMsg.SUCCESS, legacyService.queryItemName(103));
    }

    @RequestMapping("/thymeleaf")
    String thymeleafTest(Model model){
        model.addAttribute("name", "boya");
        return "hello";
    }



}
