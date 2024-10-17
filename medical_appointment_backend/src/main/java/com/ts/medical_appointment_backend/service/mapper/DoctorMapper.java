package com.ts.medical_appointment_backend.service.mapper;

import com.ts.medical_appointment_backend.controller.dtos.DoctorDto;
import com.ts.medical_appointment_backend.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "speciality", target = "speciality")
    DoctorDto toDto(Doctor doctor);
    Doctor toEntity(DoctorDto doctorDto);
}
