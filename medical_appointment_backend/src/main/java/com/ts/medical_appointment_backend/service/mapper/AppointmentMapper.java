package com.ts.medical_appointment_backend.service.mapper;

import com.ts.medical_appointment_backend.controller.dtos.AppointmentDto;
import com.ts.medical_appointment_backend.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentDto toDto(Appointment appointment);
    Appointment toEntity(AppointmentDto appointmentDto);
}
