package com.takeuforward.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeuforward.model.ContactForm;
import com.takeuforward.repo.ContactFormRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ContactFormService {

    @Autowired
    private ContactFormRepo repository;

    
    
    
    @Autowired
    private EmailService emailService;

    public ContactForm saveForm(ContactForm form) {
        ContactForm savedForm = repository.save(form);

        // Email bhejna
        String subject = "New Contact Form Submitted";
        String body = "title: "+" new contact form"
        		+ "\nName: " + form.getName() +
                "\nEmail: " + form.getEmail() +
                "\nMobile: " + form.getMobile() +
                "\nSubject: " + form.getSubject() +
                "\nDescription: " + form.getDescription();

        emailService.sendMail(subject, body);

        return savedForm;
    }

    public List<ContactForm> getAllForms() {
        return repository.findAll();
    }

    public Optional<ContactForm> getFormById(String id) {
        return repository.findById(id);
    }

    public ContactForm updateForm(String id, ContactForm updatedForm) {
        return repository.findById(id).map(form -> {
            form.setName(updatedForm.getName());
            form.setEmail(updatedForm.getEmail());
            form.setMobile(updatedForm.getMobile());
            form.setSubject(updatedForm.getSubject());
            form.setDescription(updatedForm.getDescription());
            return repository.save(form);
        }).orElseThrow(() -> new RuntimeException("Form not found"));
    }

    public void deleteForm(String id) {
        repository.deleteById(id);
    }
}
