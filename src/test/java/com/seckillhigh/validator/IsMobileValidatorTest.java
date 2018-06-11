package com.seckillhigh.validator;

import com.seckillhigh.vo.LoginVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.table.TableRowSorter;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "MainApplication.class")
public class IsMobileValidatorTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void isValid() {

        LoginVo loginVo1 = new LoginVo();

        loginVo1.setMobile("234567890");
        loginVo1.setPassword("bucu");

        LoginVo loginVo2 = new LoginVo();

        loginVo2.setMobile("17192225897");
        loginVo2.setPassword("bucu");

        System.out.println(validator.validate(loginVo1, IsMobile.class));
        System.out.println(validator.validate(loginVo2, IsMobile.class));
    }


}