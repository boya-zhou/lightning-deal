package com.seckillhigh.controller;

import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.service.Impl.impl.SecKillHighServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Controller
@EnableAutoConfiguration
@RequestMapping("/secKillItems")
public class SecKillItemsController {

    private static Logger logger = LoggerFactory.getLogger(SecKillItemsController.class);

    @Autowired
    SecKillHighServiceImpl secKillHighService;



    @RequestMapping("/list")
    String home(Model model,
                SecKillHighUser secKillHighUser) {

        model.addAttribute("user", secKillHighUser);

        return "goods_list";
    }

}
