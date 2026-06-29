package com.example.springboot_no1.entity.user;

import com.example.springboot_no1.entity.feed.FeedEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) // neu feed k co user nao thi tu remove
    @ToString.Exclude()
    private List<FeedEntity> feedList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id")
    private CCCDEntity cccdEntity;
}
