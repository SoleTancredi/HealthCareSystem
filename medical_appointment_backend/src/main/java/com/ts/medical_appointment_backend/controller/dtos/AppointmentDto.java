package com.ts.medical_appointment_backend.controller.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public class AppointmentDto {
    @NotNull(message = "Appointment date and time cannot be null.")
    @Future(message = "Appointment date and time must be in the future.")
    private Date dateTimeAppointment;

    @NotBlank(message = "Doctor's first name is required.")
    @Size(max = 50, message = "Doctor's first name cannot exceed 50 characters.")
    private String nameDoctor;

    @NotBlank(message = "Doctor's last name is required.")
    @Size(max = 50, message = "Doctor's last name cannot exceed 50 characters.")
    private String lastnameDoctor;

    @NotBlank(message = "Patient's first name is required.")
    @Size(max = 50, message = "Patient's first name cannot exceed 50 characters.")
    private String namePatient;

    @NotBlank(message = "Patient's last name is required.")
    @Size(max = 50, message = "Patient's last name cannot exceed 50 characters.")
    private String lastnamePatient;

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getLastnameDoctor() {
        return lastnameDoctor;
    }

    public void setLastnameDoctor(String lastnameDoctor) {
        this.lastnameDoctor = lastnameDoctor;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getLastnamePatient() {
        return lastnamePatient;
    }

    public void setLastnamePatient(String lastnamePatient) {
        this.lastnamePatient = lastnamePatient;
    }

    public Date getDateTimeAppointment() {
        return dateTimeAppointment;
    }

    public void setDateTimeAppointment(Date dateTimeAppointment) {
        this.dateTimeAppointment = dateTimeAppointment;
    }
}
