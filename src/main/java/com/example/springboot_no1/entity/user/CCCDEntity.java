package com.example.springboot_no1.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "java_cccd_001")
public class CCCDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String numberCCCD;

    /* khi OneToOne thi chi can dat o 1 entity*/
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private UserEntity user;
}
