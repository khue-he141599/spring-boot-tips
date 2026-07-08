package com.example.springboot_no1;

import com.example.springboot_no1.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    void sendTextEmail() throws IOException {
        String to = "";
        String subject = "";
        String content = "";

        Resource resource = new ClassPathResource("/template/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());

        emailSenderUtil.sendTextEmail(to, subject, htmlContent);
    }
}
