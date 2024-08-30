package com.vinay.springmvcdemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CouponCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CouponCode {

    // default Coupon Code
    public String value() default "VL";

    // default Error Msg
    public String message() default "must start with \"VL\"";

    // default groups
    public Class<?>[] groups() default {};

    // default payload
    public Class<? extends Payload>[] payload() default {};
}
