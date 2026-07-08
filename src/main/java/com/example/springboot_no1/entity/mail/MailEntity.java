package com.example.springboot_no1.entity.mail;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailEntity {

    private String toEmail;

    private String subject;

    private String messageBody;

    private String attachment;
}
