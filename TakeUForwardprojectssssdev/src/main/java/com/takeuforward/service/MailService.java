package com.takeuforward.service;

import com.takeuforward.model.UserModel;
import com.takeuforward.repo.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Userrepo userrepo;
//
//    public void sendAllUserDetailsToOwner() {
//        List<UserModel> users = userrepo.findAll();
//        
//
//        StringBuilder content = new StringBuilder();
//        content.append("A new user has submitted the form.\nHere are all user submissions:\n\n");
//
//        for (UserModel user : users) {
//        	 content.append("id: ").append(user.getId()).append("\n");
//            content.append("Name: ").append(user.getName()).append("\n");
//            content.append("Email: ").append(user.getEmail()).append("\n");
//            content.append("Phone: ").append(user.getMobile()).append("\n");
//            content.append("City: ").append(user.getCity()).append("\n");
//            content.append("TimeofShoot: ").append(user.getTimeOfShoot()).append("\n");
//            content.append("Status: ").append(user.getStatus()).append("\n");
//            content.append("--------------------------------------------------\n");
//        }
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("sahuaman399@gmail.com");  // your email
//        message.setSubject("New User Form Submission");
//        message.setText(content.toString());
//
//        try {
//            mailSender.send(message);
//        } catch (Exception e) {
//            e.printStackTrace();  // log error
//        }
//    }
//}
//

public void sendUserDetailsToOwner(UserModel user) {
    StringBuilder content = new StringBuilder();
    content.append("A new user has submitted the form.\nHere are the details:\n\n");
    content.append("id: ").append(user.getId()).append("\n");
    content.append("Name: ").append(user.getName()).append("\n");
    content.append("Email: ").append(user.getEmail()).append("\n");
    content.append("Phone: ").append(user.getMobile()).append("\n");
    //content.append("City: ").append(user.getCity()).append("\n");
   // content.append("TimeofShoot: ").append(user.getTimeOfShoot()).append("\n");
    content.append("Status: ").append(user.getBookingStatus()).append("\n");

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("sahuaman399@gmail.com");  // owner email
    message.setSubject("New User Form Submission");
    message.setText(content.toString());

    try {
        mailSender.send(message);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

