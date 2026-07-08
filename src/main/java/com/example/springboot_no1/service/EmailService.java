package com.example.springboot_no1.service;

import com.example.springboot_no1.entity.mail.MailEntity;

public interface EmailService {
    String sendTextEmail(MailEntity mail);
    String sendHtmlEmail(MailEntity mail);
    String sendMailAttachmentEmail(MailEntity mail);
}
