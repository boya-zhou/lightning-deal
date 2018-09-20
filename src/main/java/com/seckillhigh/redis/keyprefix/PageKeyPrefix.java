package com.seckillhigh.redis.keyprefix;

public class PageKeyPrefix extends BaseKeyPrefix {

    public static final int EXPIRE_TOKEN = 60;

    public PageKeyPrefix(int timeOut, String prefix) {
        super(timeOut, prefix);
    }

    public static PageKeyPrefix goodsList = new PageKeyPrefix(EXPIRE_TOKEN, "gl");

    public static PageKeyPrefix goodsDetail = new PageKeyPrefix(EXPIRE_TOKEN, "gd");
}
