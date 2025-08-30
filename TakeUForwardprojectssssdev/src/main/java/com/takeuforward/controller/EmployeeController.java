package com.takeuforward.controller;



import com.takeuforward.model.EmployeeModel;
import com.takeuforward.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees") // Base endpoint
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    // 🔹 POST: Submit Employee
    // Endpoint: POST http://localhost:8080/api/employees/post
    
    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public ResponseEntity<?> submitEmployee(@Valid @RequestBody EmployeeModel employee, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        EmployeeModel savedEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // 🔹 GET: Get All Employees
    // Endpoint: GET http://localhost:8080/api/employees/all
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
        List<EmployeeModel> employees = employeeRepo.findAll();
        return ResponseEntity.ok(employees);
    }

    // 🔹 GET: Get Employee by ID
    // Endpoint: GET http://localhost:8080/api/employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        Optional<EmployeeModel> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @Valid @RequestBody EmployeeModel updatedEmployee, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Optional<EmployeeModel> optionalEmployee = employeeRepo.findById(id);

        if (optionalEmployee.isPresent()) {
            EmployeeModel existing = optionalEmployee.get();

            // Update fields
            existing.setFullName(updatedEmployee.getFullName());
            existing.setEmail(updatedEmployee.getEmail());
            existing.setMobile(updatedEmployee.getMobile());
            existing.setCity(updatedEmployee.getCity());
            existing.setNearbyCities(updatedEmployee.getNearbyCities());
            existing.setPortfolioLink(updatedEmployee.getPortfolioLink());
            existing.setSocialPage(updatedEmployee.getSocialPage());
            existing.setSelectedSkills(updatedEmployee.getSelectedSkills());

            existing.setPhotographerCategories(updatedEmployee.getPhotographerCategories());
            existing.setPhotographerCameras(updatedEmployee.getPhotographerCameras());
            existing.setPhotographerEquipments(updatedEmployee.getPhotographerEquipments());
            existing.setPhotographerSkillLevel(updatedEmployee.getPhotographerSkillLevel());
            existing.setPhotographerExperience(updatedEmployee.getPhotographerExperience());

            existing.setPhotoEditorCategories(updatedEmployee.getPhotoEditorCategories());
            existing.setPhotoEditorSoftwares(updatedEmployee.getPhotoEditorSoftwares());

            existing.setVideographerCategories(updatedEmployee.getVideographerCategories());
            existing.setVideographerCameras(updatedEmployee.getVideographerCameras());
            existing.setVideographerEquipments(updatedEmployee.getVideographerEquipments());
            existing.setVideographerSoftwares(updatedEmployee.getVideographerSoftwares());
            existing.setVideographerSkillLevel(updatedEmployee.getVideographerSkillLevel());
            existing.setVideographerExperience(updatedEmployee.getVideographerExperience());

            existing.setVideoEditorCategories(updatedEmployee.getVideoEditorCategories());
            existing.setVideoEditorSoftwares(updatedEmployee.getVideoEditorSoftwares());

            existing.setIsMobileContentCreator(updatedEmployee.getIsMobileContentCreator());
            existing.setUploadedPhotos(updatedEmployee.getUploadedPhotos());

            EmployeeModel saved = employeeRepo.save(existing);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }


    // 🔹 DELETE: Delete Employee by ID
    // Endpoint: DELETE http://localhost:8080/api/employees/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        return employeeRepo.findById(id).map(employee -> {
            employeeRepo.delete(employee);
            return ResponseEntity.ok("Employee deleted successfully");
        }).orElse(ResponseEntity.status(404).body("Employee not found"));
    }
}
