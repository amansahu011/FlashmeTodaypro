package com.takeuforward.repo;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.takeuforward.model.UserModel;



public interface Userrepo extends MongoRepository<UserModel, String> {
}
