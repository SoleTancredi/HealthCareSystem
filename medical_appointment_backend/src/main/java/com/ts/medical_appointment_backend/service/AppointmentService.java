package com.ts.medical_appointment_backend.service;

import com.ts.medical_appointment_backend.controller.dtos.AppointmentDto;
import com.ts.medical_appointment_backend.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(AppointmentDto appointmentDto);
    AppointmentDto getAppointmentById(Long id);
    List<AppointmentDto> getAppointments();
    AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto);
    void deleteAppointment(Long id);
}
