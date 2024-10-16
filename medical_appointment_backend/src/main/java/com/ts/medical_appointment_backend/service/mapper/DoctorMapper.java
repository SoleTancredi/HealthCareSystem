package com.ts.medical_appointment_backend.service.mapper;

import com.ts.medical_appointment_backend.controller.dtos.DoctorDto;
import com.ts.medical_appointment_backend.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDto toDto(Doctor doctor);
    Doctor toEntity(DoctorDto doctorDto);
}
