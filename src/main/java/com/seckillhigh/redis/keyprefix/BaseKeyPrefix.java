package com.seckillhigh.redis.keyprefix;

public abstract class BaseKeyPrefix implements KeyPrefix {

    private int timeOut;

    private String prefix;

    public BaseKeyPrefix(String prefix) {
        this.timeOut = 0;
        this.prefix = prefix;
    }

    public BaseKeyPrefix(int timeOut, String prefix) {
        this.timeOut = timeOut;
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public int getTimeOut() {
        return this.timeOut;
    }
}
