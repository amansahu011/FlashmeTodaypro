package com.takeuforward.model;





import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "employees")
public class EmployeeModel {

    @Id
    private String id;  // MongoDB ObjectId

    // 🔹 Personal Details
   // @NotBlank(message = "Full Name is required")
    //@Size(min = 3, max = 100, message = "Full Name must be between 3 and 100 characters")
    private String fullName;

    //@NotBlank(message = "Email is required")
    //@Email(message = "Invalid email format")
    private String email;

   // @NotBlank(message = "Mobile number is required")
    //@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Indian mobile number")
    private String mobile;

    @NotBlank(message = "City is required")
    private String city;

    private String nearbyCities;

    //@URL(message = "Invalid Portfolio link")
    private String portfolioLink;

    private String socialPage; // FB/Insta Page

    // 🔹 Skills
    private List<String> selectedSkills; // ["photographer", "photo-editor", ...]

    // 🔹 Photographer
    private List<String> photographerCategories; // Candid, Wedding, Food, etc.
    private String photographerCameras;
    private String photographerEquipments;
    private String photographerSkillLevel;   // Amateur, Student, Professional...
    private String photographerExperience;   // Fresher, 1-2 Years...

    // 🔹 Photo Editor
    private List<String> photoEditorCategories;
    private String photoEditorSoftwares;

    // 🔹 Videographer
    private List<String> videographerCategories;
    private String videographerCameras;
    private String videographerEquipments;
    private String videographerSoftwares;
    private String videographerSkillLevel;
    private String videographerExperience;

    // 🔹 Video/Reel Editor
    private List<String> videoEditorCategories;
    private String videoEditorSoftwares;

    // 🔹 Mobile Content Creator
    private Boolean isMobileContentCreator;

    // 🔹 Uploaded Photos (min 5 required)
    //@Size(min = 5, message = "At least 5 photos must be uploaded")
    private List<String> uploadedPhotos; // store file paths / URLs

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNearbyCities() {
		return nearbyCities;
	}

	public void setNearbyCities(String nearbyCities) {
		this.nearbyCities = nearbyCities;
	}

	public String getPortfolioLink() {
		return portfolioLink;
	}

	public void setPortfolioLink(String portfolioLink) {
		this.portfolioLink = portfolioLink;
	}

	public String getSocialPage() {
		return socialPage;
	}

	public void setSocialPage(String socialPage) {
		this.socialPage = socialPage;
	}

	public List<String> getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(List<String> selectedSkills) {
		this.selectedSkills = selectedSkills;
	}

	public List<String> getPhotographerCategories() {
		return photographerCategories;
	}

	public void setPhotographerCategories(List<String> photographerCategories) {
		this.photographerCategories = photographerCategories;
	}

	public String getPhotographerCameras() {
		return photographerCameras;
	}

	public void setPhotographerCameras(String photographerCameras) {
		this.photographerCameras = photographerCameras;
	}

	public String getPhotographerEquipments() {
		return photographerEquipments;
	}

	public void setPhotographerEquipments(String photographerEquipments) {
		this.photographerEquipments = photographerEquipments;
	}

	public String getPhotographerSkillLevel() {
		return photographerSkillLevel;
	}

	public void setPhotographerSkillLevel(String photographerSkillLevel) {
		this.photographerSkillLevel = photographerSkillLevel;
	}

	public String getPhotographerExperience() {
		return photographerExperience;
	}

	public void setPhotographerExperience(String photographerExperience) {
		this.photographerExperience = photographerExperience;
	}

	public List<String> getPhotoEditorCategories() {
		return photoEditorCategories;
	}

	public void setPhotoEditorCategories(List<String> photoEditorCategories) {
		this.photoEditorCategories = photoEditorCategories;
	}

	public String getPhotoEditorSoftwares() {
		return photoEditorSoftwares;
	}

	public void setPhotoEditorSoftwares(String photoEditorSoftwares) {
		this.photoEditorSoftwares = photoEditorSoftwares;
	}

	public List<String> getVideographerCategories() {
		return videographerCategories;
	}

	public void setVideographerCategories(List<String> videographerCategories) {
		this.videographerCategories = videographerCategories;
	}

	public String getVideographerCameras() {
		return videographerCameras;
	}

	public void setVideographerCameras(String videographerCameras) {
		this.videographerCameras = videographerCameras;
	}

	public String getVideographerEquipments() {
		return videographerEquipments;
	}

	public void setVideographerEquipments(String videographerEquipments) {
		this.videographerEquipments = videographerEquipments;
	}

	public String getVideographerSoftwares() {
		return videographerSoftwares;
	}

	public void setVideographerSoftwares(String videographerSoftwares) {
		this.videographerSoftwares = videographerSoftwares;
	}

	public String getVideographerSkillLevel() {
		return videographerSkillLevel;
	}

	public void setVideographerSkillLevel(String videographerSkillLevel) {
		this.videographerSkillLevel = videographerSkillLevel;
	}

	public String getVideographerExperience() {
		return videographerExperience;
	}

	public void setVideographerExperience(String videographerExperience) {
		this.videographerExperience = videographerExperience;
	}

	public List<String> getVideoEditorCategories() {
		return videoEditorCategories;
	}

	public void setVideoEditorCategories(List<String> videoEditorCategories) {
		this.videoEditorCategories = videoEditorCategories;
	}

	public String getVideoEditorSoftwares() {
		return videoEditorSoftwares;
	}

	public void setVideoEditorSoftwares(String videoEditorSoftwares) {
		this.videoEditorSoftwares = videoEditorSoftwares;
	}

	public Boolean getIsMobileContentCreator() {
		return isMobileContentCreator;
	}

	public void setIsMobileContentCreator(Boolean isMobileContentCreator) {
		this.isMobileContentCreator = isMobileContentCreator;
	}

	public List<String> getUploadedPhotos() {
		return uploadedPhotos;
	}

	public void setUploadedPhotos(List<String> uploadedPhotos) {
		this.uploadedPhotos = uploadedPhotos;
	}

    // ✅ Getters & Setters
    // (you can use Lombok @Data to avoid boilerplate)
}
