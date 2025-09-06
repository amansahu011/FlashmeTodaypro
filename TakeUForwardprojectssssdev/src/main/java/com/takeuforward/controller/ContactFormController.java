package com.takeuforward.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.takeuforward.model.ContactForm;
import com.takeuforward.service.ContactFormService;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactFormController {

    @Autowired
    private ContactFormService service;

    
 // ✅ Create (Submit form)
    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(@Valid @RequestBody ContactForm form) {
        service.saveForm(form);  // save in DB
        return ResponseEntity.ok("Submit Successfully ✅");
    }


    // ✅ Read All
    @GetMapping("/all")
    public List<ContactForm> getAllForms() {
        return service.getAllForms();
    }

    // ✅ Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactForm> getFormById(@PathVariable String id) {
        return service.getFormById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Update
    @PutMapping("/{id}")
    public ResponseEntity<ContactForm> updateForm(@PathVariable String id, @Valid @RequestBody ContactForm form) {
        return ResponseEntity.ok(service.updateForm(id, form));
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable String id) {
        service.deleteForm(id);
        return ResponseEntity.noContent().build();
    }
}
