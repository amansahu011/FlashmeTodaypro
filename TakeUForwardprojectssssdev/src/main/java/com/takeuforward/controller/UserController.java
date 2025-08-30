//package com.takeuforward.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import com.takeuforward.model.UserModel;
//import com.takeuforward.repo.Userrepo;
//
//import jakarta.validation.Valid;
//
//// Add this import for email service
//
//import com.takeuforward.service.MailService;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/api/form")
//public class UserController {
//
//    @Autowired
//    private Userrepo userrepo;
//
//    @Autowired
//    private MailService emailService;   // Inject EmailService
//
//    @PostMapping("/submit")
//    public ResponseEntity<?> submitForm(@Valid @RequestBody UserModel data, BindingResult result) {
//        if (result.hasErrors()) {
//            List<String> errors = result.getFieldErrors().stream()
//                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
//                    .collect(Collectors.toList());
//            return ResponseEntity.badRequest().body(errors);
//        }
//
//        // Save the new user to DB
//        userrepo.save(data);
//
//        // Send email with all user data
//        emailService.sendAllUserDetailsToOwner();
//
//        return ResponseEntity.ok("Form submitted successfully!");
//    }
//
//
//
//    @GetMapping("/all")
//    public List<UserModel> getAllForms() {
//        return userrepo.findAll();
//    }
//}
package com.takeuforward.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.takeuforward.model.UserModel;
import com.takeuforward.repo.Userrepo;

import jakarta.validation.Valid;

import com.takeuforward.service.MailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/form")
public class UserController {

    @Autowired
    private Userrepo userrepo;

    @Autowired
    private MailService emailService;   // Inject EmailService

    @PostMapping("/submit")
    public ResponseEntity<?> submitForm(@Valid @RequestBody UserModel data, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        // Save the new user to DB
        UserModel savedUser = userrepo.save(data);

        // ✅ Send email with only the newly submitted user data
        emailService.sendUserDetailsToOwner(savedUser);

        return ResponseEntity.ok("Form submitted successfully!");
    }

    @GetMapping("/all")
    public List<UserModel> getAllForms() {
        return userrepo.findAll();
    }
}


