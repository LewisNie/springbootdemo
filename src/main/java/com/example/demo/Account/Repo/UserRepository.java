package com.example.demo.Account.Repo;


import com.example.demo.Account.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
     UserEntity findByLogin(String login);
     boolean existsByLogin(String login);
}
