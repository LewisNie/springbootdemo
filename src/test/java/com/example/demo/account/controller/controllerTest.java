package com.example.demo.account.controller;

import com.example.demo.Account.Controller.UserController;
import com.example.demo.Account.Entity.UserEntity;
import com.example.demo.Account.Repo.UserRepository;
import com.example.demo.Account.dto.UserLoginRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.annotation.Target;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class controllerTest {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    UserController userController;

    @Autowired
    UserRepository userRepository;

    @Test
    public void checkUser(){
        UserLoginRequest request = new UserLoginRequest();
        request.setLogin("sadasd");
        request.setPassword("123456");
        ResponseEntity<UserEntity> response = restTemplate.postForEntity("http://localhost:8080/user",request,UserEntity.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getLogin(),"sadasd");
        assertEquals(response.getBody().getPassword(),"123456");
    }

    @Test
    public void BasicAuthTest(){
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin("yaoyuannie");
        userEntity.setPassword("123456");
        userRepository.save(userEntity);

        UserLoginRequest request = new UserLoginRequest();
        request.setLogin("sadasd");
        request.setPassword("654321");
        ResponseEntity<UserEntity> response = restTemplate.postForEntity("http://localhost:8080/user",request,UserEntity.class);
        assertEquals(response.getBody().getLogin(),"sadasd");
    }

}
