package com.seckillhigh.controller;

import com.seckillhigh.result.CodeMsg;
import com.seckillhigh.result.Result;
import com.seckillhigh.service.Impl.LegacyService;
import com.seckillhigh.service.Impl.SecKillHighService;
import com.seckillhigh.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LegacyService legacyService;

    @Autowired
    SecKillHighService secKillHighService;

    @RequestMapping("/to_login")
    String home() {
        return "login";
    }

    @RequestMapping(value = "/do_login", consumes = "application/json")
    @ResponseBody
    Result<Boolean> doLogin(HttpServletResponse response,
                            @Valid @RequestBody LoginVo loginVo) {

        Boolean res = secKillHighService.doLogin(response, loginVo);
        return Result.success(CodeMsg.SUCCESS, res);

    }

}
