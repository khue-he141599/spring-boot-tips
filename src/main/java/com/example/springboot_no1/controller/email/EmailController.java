package com.example.springboot_no1.controller.email;

import com.example.springboot_no1.entity.mail.MailEntity;
import com.example.springboot_no1.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send_text")
    public String sendTextEmail(@RequestBody() MailEntity mail) {
        return emailService.sendTextEmail(mail);
    }

    @PostMapping("/send_html")
    public String sendHtmlEmail(@RequestBody() MailEntity mail) {
        return emailService.sendHtmlEmail(mail);
    }
}
