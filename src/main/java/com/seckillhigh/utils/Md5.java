package com.seckillhigh.utils;

import org.springframework.util.DigestUtils;

public class Md5 {

    public static final String salt = "1a2b3c4d";

    public static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

    public static String inputPassToForm(String src){
        return md5(src + salt);
    }

    public static  String formPassToDB(String src, String saltDB){
        return md5(src + saltDB);
    }

    public static  String inputPassToDB(String src, String saltDB){

        return formPassToDB(inputPassToForm(src), saltDB);

    }

    public static void main(String[] args) {
        System.out.println(inputPassToDB("chimantou", salt));
    }

}
