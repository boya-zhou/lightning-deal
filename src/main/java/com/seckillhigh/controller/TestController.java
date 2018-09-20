package com.seckillhigh.controller;

import com.seckillhigh.rabbitmq.MsgSender;
import com.seckillhigh.result.Result;
import com.seckillhigh.utils.UserUtil;
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
    UserUtil userUtil;

    @Autowired
    MsgSender msgSender;

    @RequestMapping("/")
    @ResponseBody
    Result<String> home(){

//        userUtil.insertAndCreateFakeConfig(5000);

        return Result.success("success");
    }

    @RequestMapping("/mq")
    @ResponseBody
    Result<String> mq(){

        msgSender.send("hello boya");
        return Result.success("success");
    }



    @RequestMapping("/thymeleaf")
    String thymeleafTest(Model model){
        model.addAttribute("name", "boya");
        return "hello";
    }

}
