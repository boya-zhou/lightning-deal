package com.seckillhigh.config;

import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.redis.RedisDao;
import com.seckillhigh.service.Impl.SecKillHighService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class SecKillUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    SecKillHighService secKillHighService;

    @Autowired
    RedisDao<SecKillHighUser> redisDao;

    static Logger logger = LoggerFactory.getLogger(SecKillUserArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        // TODO: find methodparameter can match which parameter
        return methodParameter.getParameterType().equals(SecKillHighUser.class);
    }

    @Override
    public SecKillHighUser resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        String paramToken = request.getParameter(SecKillHighService.COOKIE_NAME_TOKEN);

        String cookieToken = getCookie(request, SecKillHighService.COOKIE_NAME_TOKEN);

        if ((StringUtils.isEmpty(paramToken) && StringUtils.isEmpty(cookieToken))) {
            return null;
        }

        String token = StringUtils.isEmpty(cookieToken) ? paramToken : cookieToken;

        SecKillHighUser secKillHighUser = secKillHighService.getUserByToken(response, token);

        if (secKillHighUser == null){
            logger.info(token);
        }

        return secKillHighUser;
    }

    private String getCookie(HttpServletRequest request, String cookieNameToken) {

        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length <= 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(SecKillHighService.COOKIE_NAME_TOKEN)) {
                return cookie.getValue();
            }
        }

        return null;

    }
}
