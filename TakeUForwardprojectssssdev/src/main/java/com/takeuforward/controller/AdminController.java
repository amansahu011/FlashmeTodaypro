package com.takeuforward.controller;


import com.takeuforward.model.UserModel;
import com.takeuforward.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        boolean isAuthenticated = adminService.login(username, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Username and Password Not Matched ");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @PatchMapping("/user/{id}/reviewed")
    public ResponseEntity<String> markReviewed(@PathVariable String id) {
        boolean result = adminService.markUserAsReviewed(id);
        if (result) {
            return ResponseEntity.ok("User marked as reviewed");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}

