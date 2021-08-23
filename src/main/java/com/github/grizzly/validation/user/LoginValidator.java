package com.github.grizzly.validation.user;

import com.github.grizzly.annotations.ValidLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<ValidLogin, String> {

    @Override
    public void initialize(ValidLogin constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return UserValidationUtils.isValidLogin(value);
    }

}
