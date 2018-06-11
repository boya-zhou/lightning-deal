package com.seckillhigh.entity;

import java.time.LocalDateTime;

public class SecKillHighUser {
    private int id;
    private String phoneId;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private LocalDateTime registerDate;
    private LocalDateTime lastLoginDate;
    private Integer loginCount;

    public int getId() {
        return id;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getHead() {
        return head;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    @Override
    public String toString() {
        return "SecKillHighUser{" +
                "id=" + id +
                ", phoneId=" + phoneId +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", head='" + head + '\'' +
                ", registerDate=" + registerDate +
                ", lastLoginDate=" + lastLoginDate +
                ", loginCount=" + loginCount +
                '}';
    }
}
