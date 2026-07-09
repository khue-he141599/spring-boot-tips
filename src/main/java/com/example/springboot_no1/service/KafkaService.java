package com.example.springboot_no1.service;

import com.example.springboot_no1.entity.mail.MailEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.w3c.dom.ranges.RangeException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
public class KafkaService {

    @Autowired
    private EmailService emailService;

    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "otp-auth-topic", groupId = "otp-group-id")
    public void listOtp(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            String email = jsonNode.get("email").asString();
            String otp = jsonNode.get("otp").asString();
            log.info("otp is {} and email is {}", otp, email);

            MailEntity mail = new MailEntity();
            mail.setSubject("Send OTP from Kafka");
            mail.setToEmail(email);
            mail.setMessageBody("OTP is" + otp);

            String result = emailService.sendTextEmail(mail);
            log.info("result is {}, otp is {}", result, otp);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
