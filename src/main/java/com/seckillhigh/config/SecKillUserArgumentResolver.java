package com.seckillhigh.config;

import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.service.Impl.impl.SecKillHighServiceImpl;
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
    SecKillHighServiceImpl secKillHighService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return SecKillHighUser.class == methodParameter.getParameterType();
    }

    @Override
    public SecKillHighUser resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        String paramToken = request.getParameter(SecKillHighServiceImpl.COOKIE_NAME_TOKEN);

        String cookieToken = getCookie(request, SecKillHighServiceImpl.COOKIE_NAME_TOKEN);

        if ((StringUtils.isEmpty(paramToken) && StringUtils.isEmpty(cookieToken))){
            return null;
        }

        String token = StringUtils.isEmpty(cookieToken)? paramToken: cookieToken;

        SecKillHighUser secKillHighUser = secKillHighService.getUserByToken(response, token);

        return secKillHighUser;
    }

    private String getCookie(HttpServletRequest request, String cookieNameToken) {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie:cookies){
            if (cookie.getName().equals(SecKillHighServiceImpl.COOKIE_NAME_TOKEN)){
                return cookie.getValue();
            }
        }

        return null;

    }
}
