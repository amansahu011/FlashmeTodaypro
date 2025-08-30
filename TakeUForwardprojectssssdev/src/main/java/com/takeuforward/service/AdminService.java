package com.takeuforward.service;

import com.takeuforward.model.UserModel;
import com.takeuforward.repo.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private Userrepo userrepo;

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin123";

    // Hardcoded admin login check (no AdminRepo)
    public boolean login(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    // Keep user-related methods if you want to use Userrepo
    public List<UserModel> getAllUsers() {
        return userrepo.findAll();
    }

    public boolean markUserAsReviewed(String id) {
        Optional<UserModel> optionalUser = userrepo.findById(id);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            user.setBookingStatus("Reviewed");  // Fix typo here if needed
            userrepo.save(user);
            return true;
        }
        return false;
    }
}

