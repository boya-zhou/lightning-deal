package com.seckillhigh.redis.keyprefix;

public class GoodsVOKeyPrefix extends BaseKeyPrefix {

    public GoodsVOKeyPrefix(String prefix) {
        super(prefix);
    }

    public GoodsVOKeyPrefix(int timeOut, String prefix) {
        super(timeOut, prefix);
    }

    public static GoodsVOKeyPrefix goodsVOKeyPrefix = new GoodsVOKeyPrefix("gv");
}
