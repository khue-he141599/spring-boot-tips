package com.example.springboot_no1.repository;

import com.example.springboot_no1.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

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

    @Query("SELECT u from UserEntity u where u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntityBy(String userName, String userEmail);

    @Query("SELECT u from UserEntity u where u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName,@Param("userEmail") String userEmail);

    // update - delete
    @Modifying
    @Query("UPDATE UserEntity u set u.userName =: userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // native query - get count user
    @Query(value = "SELECT COUNT(u.id) from java_user_001", nativeQuery = true)
    long getToalUser();

    // Phân trang
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
}
