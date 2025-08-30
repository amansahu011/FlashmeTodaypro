package com.takeuforward.repo;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.takeuforward.model.ContactForm;

@Repository
public interface ContactFormRepo extends MongoRepository<ContactForm, String> {
}
