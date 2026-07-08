package com.example.springboot_no1.service.impl;

import com.example.springboot_no1.entity.mail.MailEntity;
import com.example.springboot_no1.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL_HOST = "";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendTextEmail(MailEntity mail) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mail.getToEmail());
        message.setSubject(mail.getSubject());
        message.setText(mail.getMessageBody());
        message.setFrom(EMAIL_HOST);

        try {
            javaMailSender.send(message);
            System.out.println("Email send success");
            return "OKE";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendHtmlEmail(MailEntity mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(mail.getToEmail());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getMessageBody());
            helper.setFrom(EMAIL_HOST);

            javaMailSender.send(message);
            System.out.println("Email send success");

            return "OKE";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendMailAttachmentEmail(MailEntity mail) {
        return "";
    }
}
