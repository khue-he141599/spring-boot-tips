package com.example.springboot_no1.repository;

import com.example.springboot_no1.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/*
1:
Annotation spring:
@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
*/
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    /*
        sẽ phải có tiền tố là find || get và đặt giá tên tìm kiếm đúng với entity
        có bảng convert từ text sang cú pháp database
    */
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    UserEntity findByUserName(String userName);

    // ?%
    List<UserEntity> findByUserNameStartingWith(String userName);

    // %?
    List<UserEntity> findByUserNameEndingWith(String userName);

    // <?
    List<UserEntity> findByIdLessThan(Long id);

    //RAW JPQL -> extends : JpaSpecificationExecutor
    @Query("SELECT u from UserEntity u where u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxId();
}
