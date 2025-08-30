package com.takeuforward.repo;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.takeuforward.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends MongoRepository<EmployeeModel, String> {

    // future me custom query likh sakte ho:
    // List<EmployeeModel> findByDepartment(String department);
    // Optional<EmployeeModel> findByEmail(String email);
}
