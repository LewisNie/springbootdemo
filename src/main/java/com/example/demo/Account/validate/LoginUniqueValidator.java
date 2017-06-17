package com.example.demo.Account.validate;


import com.example.demo.Account.Repo.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginUniqueValidator implements ConstraintValidator<LoginUnique,String>{
    private UserRepository userRepository;

    public LoginUniqueValidator(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void initialize(LoginUnique loginUnique){};

    public boolean isValid(String  login,ConstraintValidatorContext cxt){
        return !userRepository.existsByLogin(login);
    }
}
