package com.seckillhigh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class SecKillHighUser implements Serializable {
    private int id;
    private String phoneId;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
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
