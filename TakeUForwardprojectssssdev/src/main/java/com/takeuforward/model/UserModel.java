//package com.takeuforward.model;
//
//
//import jakarta.validation.constraints.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "formdata")
//public class UserModel {
//    @Id
//    private String id;
//
//    @NotBlank(message = "Name is required")
//    private String name;
//
//    @NotBlank(message = "Email is required")
//    @Email(message = "Email should be valid")
//    private String email;
//
//    @NotBlank(message = "Location is required")
//    private String location;
//
//    @NotBlank(message = "Mobile number is required")
//    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be 10 digits")
//    private String mobile;
//
//    @NotBlank(message = "City is required")
//    private String city;
//
//    @NotBlank(message = "Time of shoot is required")
//    private String timeOfShoot;
//
//    private String status = "Pending";  // New field: Default "Pending"
//
//    // Getters and Setters (including for status)
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getTimeOfShoot() {
//        return timeOfShoot;
//    }
//
//    public void setTimeOfShoot(String timeOfShoot) {
//        this.timeOfShoot = timeOfShoot;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}

package com.takeuforward.model;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Booking")
public class UserModel {

    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(
    	    regexp = "^(?:0|91)?[0-9]{10}$",
    	    message = "Mobile must be a valid 10-digit number (with optional 0 or 91 prefix)"
    	)
    	private String mobile;
    
    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Time of shoot is required")
    private String timeOfShoot;

    @NotBlank(message = "Plan is required")
    private String plan;

    @NotBlank(message = "Type of shoot is required")
    private String typeOfShoot;

    // renamed for clarity
    private String BookingStatus = "Pending"; 

    // Getters & Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimeOfShoot() {
        return timeOfShoot;
    }
    public void setTimeOfShoot(String timeOfShoot) {
        this.timeOfShoot = timeOfShoot;
    }

    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getTypeOfShoot() {
        return typeOfShoot;
    }
    public void setTypeOfShoot(String typeOfShoot) {
        this.typeOfShoot = typeOfShoot;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }
    public void setBookingStatus(String bookingStatus) {
        this.BookingStatus = bookingStatus;
    }
}
