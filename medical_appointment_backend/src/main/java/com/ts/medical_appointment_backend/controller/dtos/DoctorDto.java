package com.ts.medical_appointment_backend.controller.dtos;

import com.ts.medical_appointment_backend.entity.Speciality;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DoctorDto {

    private Long id;
    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 50, message = "Name cannot exceed 50 characters.")
    private String name;

    @NotBlank(message = "Lastname cannot be empty.")
    @Size(max = 50, message = "Lastname cannot exceed 50 characters.")
    private String lastname;

    @NotNull(message = "Speciality is required")
    private Speciality speciality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }


}
