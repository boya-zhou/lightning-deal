package com.seckillhigh.vo;

import com.seckillhigh.validator.IsMobile;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LoginVo implements Serializable {

    @NotEmpty
    @IsMobile(required = true)
    public String mobile;

    @NotEmpty
    @Length(min = 5)
    public String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile=" + mobile +
                ", password='" + password + '\'' +
                '}';
    }
}
