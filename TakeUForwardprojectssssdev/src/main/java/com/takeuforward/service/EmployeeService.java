package com.takeuforward.service;





import com.takeuforward.model.EmployeeModel;
import com.takeuforward.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    // ➤ Create New Employee
    public EmployeeModel createEmployee(EmployeeModel employee) {
        return employeeRepo.save(employee);
    }

    // ➤ Get All Employees
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // ➤ Get Employee by ID
    public Optional<EmployeeModel> getEmployeeById(String id) {
        return employeeRepo.findById(id);
    }

    // ➤ Update Employee (using your real fields)
    public EmployeeModel updateEmployee(String id, EmployeeModel updatedEmployee) {
        return employeeRepo.findById(id).map(existing -> {
            // 🔹 Personal
            existing.setFullName(updatedEmployee.getFullName());
            existing.setEmail(updatedEmployee.getEmail());
            existing.setMobile(updatedEmployee.getMobile());
            existing.setCity(updatedEmployee.getCity());
            existing.setNearbyCities(updatedEmployee.getNearbyCities());
            existing.setPortfolioLink(updatedEmployee.getPortfolioLink());
            existing.setSocialPage(updatedEmployee.getSocialPage());

            // 🔹 Skills
            existing.setSelectedSkills(updatedEmployee.getSelectedSkills());

            // 🔹 Photographer
            existing.setPhotographerCategories(updatedEmployee.getPhotographerCategories());
            existing.setPhotographerCameras(updatedEmployee.getPhotographerCameras());
            existing.setPhotographerEquipments(updatedEmployee.getPhotographerEquipments());
            existing.setPhotographerSkillLevel(updatedEmployee.getPhotographerSkillLevel());
            existing.setPhotographerExperience(updatedEmployee.getPhotographerExperience());

            // 🔹 Photo Editor
            existing.setPhotoEditorCategories(updatedEmployee.getPhotoEditorCategories());
            existing.setPhotoEditorSoftwares(updatedEmployee.getPhotoEditorSoftwares());

            // 🔹 Videographer
            existing.setVideographerCategories(updatedEmployee.getVideographerCategories());
            existing.setVideographerCameras(updatedEmployee.getVideographerCameras());
            existing.setVideographerEquipments(updatedEmployee.getVideographerEquipments());
            existing.setVideographerSoftwares(updatedEmployee.getVideographerSoftwares());
            existing.setVideographerSkillLevel(updatedEmployee.getVideographerSkillLevel());
            existing.setVideographerExperience(updatedEmployee.getVideographerExperience());

            // 🔹 Video/Reel Editor
            existing.setVideoEditorCategories(updatedEmployee.getVideoEditorCategories());
            existing.setVideoEditorSoftwares(updatedEmployee.getVideoEditorSoftwares());

            // 🔹 Mobile Content Creator
            existing.setIsMobileContentCreator(updatedEmployee.getIsMobileContentCreator());

            // 🔹 Uploaded Photos
            existing.setUploadedPhotos(updatedEmployee.getUploadedPhotos());

            return employeeRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("❌ Employee not found with id: " + id));
    }

    // ➤ Delete Employee
    public boolean deleteEmployee(String id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
