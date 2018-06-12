package com.seckillhigh.controller;


import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class UserController {

    @RequestMapping("/user/info")
    @ResponseBody
    Result<SecKillHighUser> getUser(Model model,
                                    SecKillHighUser user) {
        return Result.success(user);

    }
}
