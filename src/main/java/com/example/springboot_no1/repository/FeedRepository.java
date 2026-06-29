package com.example.springboot_no1.repository;

import com.example.springboot_no1.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

}
