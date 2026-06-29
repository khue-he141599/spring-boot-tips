package com.example.springboot_no1;

import com.example.springboot_no1.entity.feed.FeedEntity;
import com.example.springboot_no1.entity.user.UserEntity;
import com.example.springboot_no1.repository.FeedRepository;
import com.example.springboot_no1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserFeedTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void oneToManyTest() {
        // 1.UserEntity
        UserEntity userEntity = new UserEntity();
        FeedEntity feedEntity = new FeedEntity();

        userEntity.setUserName("khuend1");
        userEntity.setUserEmail("khuend1@gmail.com");

        feedEntity.setTitle("feed 01");
        feedEntity.setDescription("descition feed 001");
        userEntity.setFeedList(List.of(feedEntity));
        feedEntity.setUser(userEntity);

        userRepository.save(userEntity);
        feedRepository.save(feedEntity);

    }

    @Test
    void oneToOne() {
        UserEntity userEntity = new UserEntity();

    }

    @Test
    @Transactional
    void selectOneToMany() {
        UserEntity user = userRepository.findById(3L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeedList());
    }
}
