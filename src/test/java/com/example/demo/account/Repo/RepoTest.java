package com.example.demo.account.Repo;

import com.example.demo.Account.Entity.UserEntity;
import com.example.demo.Account.Repo.UserRepository;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepoTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUserTest(){
        UserEntity user = new UserEntity();
        user.setLogin("yaoyuannie");
        user.setPassword("dfsfds");
        userRepository.save(user);
        UserEntity saved = userRepository.findOne(user.getId());
        assertEquals(user.getLogin(),saved.getLogin());
    }
}
