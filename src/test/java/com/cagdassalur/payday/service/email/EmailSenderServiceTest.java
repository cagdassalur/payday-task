package com.cagdassalur.payday.service.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ExtendWith(MockitoExtension.class)
class EmailSenderServiceTest {
    private static final String toMail = "test@example.com";
    private static final String subject = "Subject";
    private static final String fromMail = "test@example.com";
    private static final String text = "email test";

    @InjectMocks
    EmailSenderService emailSenderService;

    @Mock
    JavaMailSender javaMailSender;

    @Test
    void sendEmail() {
        JavaMailSender javaMailSender = new JavaMailSenderImpl();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        emailSenderService.sendEmail(toMail,subject,fromMail,text);
    }

}