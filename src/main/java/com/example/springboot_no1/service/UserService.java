package com.example.springboot_no1.service;

import com.example.springboot_no1.entity.user.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
}
