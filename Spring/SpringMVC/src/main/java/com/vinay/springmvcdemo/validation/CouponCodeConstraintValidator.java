package com.vinay.springmvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CouponCodeConstraintValidator implements ConstraintValidator<CouponCode, String> {

    private String couponPrefix;

    @Override
    public void initialize(CouponCode couponCode) {
        couponPrefix = couponCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if(code == null)
            return true;
        return code.startsWith(couponPrefix);
    }
}
