package com.example.springboot_no1.controller.user;

import com.example.springboot_no1.entity.user.UserEntity;
import com.example.springboot_no1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody() UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String name, @RequestParam String email) {
        return userService.findByUserNameAndUserEmail(name, email);
    }



}
