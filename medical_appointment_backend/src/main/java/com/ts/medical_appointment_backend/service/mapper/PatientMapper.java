package com.ts.medical_appointment_backend.service.mapper;

import com.ts.medical_appointment_backend.controller.dtos.PatientDto;
import com.ts.medical_appointment_backend.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto patientDto);
}
