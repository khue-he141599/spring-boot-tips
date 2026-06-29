package com.example.springboot_no1;

import com.example.springboot_no1.entity.user.CCCDEntity;
import com.example.springboot_no1.entity.user.UserEntity;
import com.example.springboot_no1.repository.UserCCCDRepository;
import com.example.springboot_no1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserCCCDTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCCCDRepository userCCCDRepository;

    @Test
    @Transactional
    void oneToOneTest() {
        UserEntity userEntity  = new UserEntity();
        CCCDEntity cccdEntity = new CCCDEntity();

        userEntity.setUserName("khuend3");
        userEntity.setUserEmail("khuend3@gmail.com");

        cccdEntity.setNumberCCCD("11111");
        userCCCDRepository.save(cccdEntity);
        userRepository.save(userEntity);
    }

    @Test
    @Transactional
    void getOneToOne() {
        UserEntity user = userRepository.findById(2L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getCccdEntity());
    }
}