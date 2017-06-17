package com.example.demo.Account.dto;

import com.example.demo.Account.validate.LoginUnique;
import com.example.demo.Account.validate.Password;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.UniqueConstraint;
import java.util.Objects;


public class UserLoginRequest {
    @NotBlank(message = "cannot be null")
    @LoginUnique
    private String login;
    @Password
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
