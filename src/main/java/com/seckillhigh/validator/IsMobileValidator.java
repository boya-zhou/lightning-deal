package com.seckillhigh.validator;

import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    public static final Pattern regex = Pattern.compile("1\\d{10}");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher matcher = regex.matcher(value);

        if (required) {
            return matcher.matches() ? true : false;
        } else {
            if (StringUtil.isNullOrEmpty(value)) {
                return true;
            } else {
                return matcher.matches() ? true : false;
            }
        }
    }

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }
}
