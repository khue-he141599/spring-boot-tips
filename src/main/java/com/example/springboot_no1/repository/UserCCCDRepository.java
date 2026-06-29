package com.example.springboot_no1.repository;

import com.example.springboot_no1.entity.user.CCCDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCCCDRepository extends JpaRepository<CCCDEntity, Long> {
}
