package com.seckillhigh.redis.keyprefix;

public class SeckillKeyPrefix extends BaseKeyPrefix {

    public static final int EXPIRE_TOKEN =3600 * 2 * 24;

    public SeckillKeyPrefix(int timeOut, String prefix) {
        super(timeOut, prefix);
    }

    public static SeckillKeyPrefix token = new SeckillKeyPrefix(EXPIRE_TOKEN, "tk");
}
