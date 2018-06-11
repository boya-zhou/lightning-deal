package com.seckillhigh.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsMobileValidator.class)
public @interface IsMobile {
    boolean required() default true;
    String message() default "The phone id is not correct";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
