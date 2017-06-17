package com.example.demo.Account.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by luyuann on 6/15/2017.
 */
public class PasswordValidator implements ConstraintValidator<Password,String> {
    @Override
    public void initialize(Password password){}

    public boolean isValid(String password, ConstraintValidatorContext cxt){
        if(password.trim().length()==0) return false;
        else return true;
    }
}
