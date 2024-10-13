package com.ts.medical_appointment_backend.controller.dtos;

import jakarta.validation.constraints.*;

public class PatientDto {

    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 50, message = "Name cannot exceed 50 characters.")
    private String name;

    @NotBlank(message = "Last name cannot be empty.")
    @Size(max = 50, message = "Last name cannot exceed 50 characters.")
    private String lastName;

    @Min(value = 0, message = "Age must be a positive number.")
    private int age;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email should be valid.")
    private String mail;

    @NotBlank(message = "Phone cannot be empty.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits.")
    private String phone;

    @NotBlank(message = "Address cannot be empty.")
    @Size(max = 100, message = "Address cannot exceed 100 characters.")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
