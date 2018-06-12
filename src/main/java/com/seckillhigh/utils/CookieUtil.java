package com.seckillhigh.utils;

import com.seckillhigh.service.Impl.SecKillHighService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    public static String getCookie(HttpServletRequest request, String cookieNameToken) {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie:cookies){
            if (cookie.getName().equals(SecKillHighService.COOKIE_NAME_TOKEN)){
                return cookie.getValue();
            }
        }

        return null;

    }
}
