package com.zzr.springboot2mvc.validation;

import com.zzr.springboot2mvc.anno.demoAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class demoAnnoValidation implements ConstraintValidator<demoAnnotation,Integer> {
    @Override
    public void initialize(demoAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
