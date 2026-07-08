package com.example.springboot_no1.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderUtil {

    private static final String EMAIL_HOST = "khuend@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTextEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(EMAIL_HOST);

        try {
            javaMailSender.send(message);
            System.out.println("Email send success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEmailTemplate(String to, String subject, String content)  {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.setFrom(EMAIL_HOST);

            javaMailSender.send(message);
            System.out.println("Email send success");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
