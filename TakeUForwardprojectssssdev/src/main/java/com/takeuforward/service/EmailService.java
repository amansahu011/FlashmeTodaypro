package com.takeuforward.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Sales.flashmetoday@gmail.com");  // tumhara gmail
        message.setTo("Sales.flashmetoday@gmail.com");    // tumhe hi email milega
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}

