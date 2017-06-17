package com.example.demo.Account.Controller;

import com.example.demo.Account.Entity.UserEntity;
import com.example.demo.Account.Repo.UserRepository;
import com.example.demo.Account.dto.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserEntity User(@Valid @RequestBody UserLoginRequest request){
        UserEntity presavedUser = new UserEntity();
        presavedUser.setLogin("yaoyuannie");
        presavedUser.setPassword("123456");
        userRepository.save(presavedUser);

        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(request.getPassword());
        userEntity.setLogin(request.getLogin());
        userRepository.save(userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    UserEntity getUser(@PathVariable("id") String id){
        return userRepository.findOne(Integer.parseInt(id));
    }
}
