package com.takeuforward.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.takeuforward.model.UserModel;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendFormDetailsToOwner(UserModel user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("sahuaman399@gmail.com"); // Your email
        message.setSubject("New Form Submission - " + user.getName());

        StringBuilder content = new StringBuilder();
        content.append("A new user has filled the form. Details are below:\n\n");
        content.append("Name: ").append(user.getName()).append("\n");
        content.append("Email: ").append(user.getEmail()).append("\n");
        content.append("Phone: ").append(user.getMobile()).append("\n");
        content.append("City: ").append(user.getCity()).append("\n");
        content.append("Message: ").append(user.getTimeOfShoot()).append("\n");

        message.setText(content.toString());
        try {
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

