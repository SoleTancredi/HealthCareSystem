package com.ts.medical_appointment_backend.service.mapper;

import com.ts.medical_appointment_backend.controller.dtos.PatientDto;
import com.ts.medical_appointment_backend.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto patientDto);
}
