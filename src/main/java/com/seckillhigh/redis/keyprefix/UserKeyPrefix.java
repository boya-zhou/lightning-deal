package com.seckillhigh.redis.keyprefix;

public class UserKeyPrefix extends BaseKeyPrefix {

    public UserKeyPrefix(String prefix) {
        super(prefix);
    }

    public UserKeyPrefix(int timeOut, String prefix) {
        super(timeOut, prefix);
    }

    public static UserKeyPrefix userId = new UserKeyPrefix("id");

    public static UserKeyPrefix useName = new UserKeyPrefix("name");
}
