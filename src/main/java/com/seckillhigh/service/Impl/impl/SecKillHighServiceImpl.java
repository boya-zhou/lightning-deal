package com.seckillhigh.service.Impl.impl;

import com.seckillhigh.dao.SecKillHighUserDao;
import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.exception.GlobalException;
import com.seckillhigh.redis.RedisDao;
import com.seckillhigh.redis.keyprefix.SeckillKeyPrefix;
import com.seckillhigh.result.CodeMsg;
import com.seckillhigh.utils.Md5;
import com.seckillhigh.utils.UUIDUtil;
import com.seckillhigh.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class SecKillHighServiceImpl {

    public static final String COOKIE_NAME_TOKEN = "cookie_uuid";

    @Autowired
    SecKillHighUserDao secKillHighUserDao;

    @Autowired
    RedisDao<SecKillHighUser> redisDao;

    public SecKillHighUser queryUser(Long phoneId) {
        return secKillHighUserDao.queryUser(phoneId);
    }

    public SecKillHighUser getUserByToken(HttpServletResponse response, String token){

        if (StringUtils.isEmpty(token)){
            return null;
        }

        SecKillHighUser secKillHighUser = redisDao.getSingleEle(SeckillKeyPrefix.token, token);

        if (secKillHighUser != null){
            addCookie(response, secKillHighUser, token);
        }

        return secKillHighUser;
    }

    public boolean doLogin(HttpServletResponse response, LoginVo loginVo) {

        SecKillHighUser secKillHighUser = secKillHighUserDao.queryUser(Long.valueOf(loginVo.getMobile()));

        if (secKillHighUser == null) {
            throw new GlobalException(CodeMsg.NO_USER_ERROR);
        }

        String finalPassWord = Md5.formPassToDB(loginVo.getPassword(), secKillHighUser.getSalt());

        if (!secKillHighUser.getPassword().equals(finalPassWord)) {
            throw new GlobalException(CodeMsg.PASSCODE_ERROR);
        }

        String token = UUIDUtil.uuid();
        addCookie(response, secKillHighUser, token);

        return true;
    }

    private void addCookie(HttpServletResponse response, SecKillHighUser secKillHighUser, String token) {

        redisDao.saveSingleEle(SeckillKeyPrefix.token, secKillHighUser.getPhoneId(), secKillHighUser);

        Cookie tokenCookie = new Cookie(COOKIE_NAME_TOKEN, token);
        tokenCookie.setMaxAge(SeckillKeyPrefix.EXPIRE_TOKEN);
        tokenCookie.setPath("/");

        response.addCookie(tokenCookie);
    }
}
