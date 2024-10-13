package com.ts.medical_appointment_backend.controller.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class AppointmentDto {
    @NotNull(message = "Appointment date and time cannot be null.")
    @Future(message = "Appointment date and time must be in the future.")
    private Date dateTimeAppointment;

    public Date getDateTimeAppointment() {
        return dateTimeAppointment;
    }

    public void setDateTimeAppointment(Date dateTimeAppointment) {
        this.dateTimeAppointment = dateTimeAppointment;
    }
}
