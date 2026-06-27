package com.example.springboot_no1.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "java_user_001")
@DynamicInsert /* chỉ nên bao gồm các cột có giá trị*/
@DynamicUpdate
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'user name'", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255) comment 'email'", nullable = false, unique = true)
    private String userEmail;
}
