package com.ts.medical_appointment_backend.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public class MedicalHistoryDto {
    @NotBlank(message = "Description cannot be empty.")
    @Size(max = 100, message = "Description cannot exceed 500 characters.")
    private String description;

    @NotNull(message = "Date of appointment cannot be null.")
    @PastOrPresent(message = "Date of appointment must be in the past or present.")
    private Date dateOfAppointment;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }
}
