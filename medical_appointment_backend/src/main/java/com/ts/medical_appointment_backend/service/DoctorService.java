package com.ts.medical_appointment_backend.service;

import com.ts.medical_appointment_backend.controller.dtos.DoctorDto;
import com.ts.medical_appointment_backend.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor createDoctor(DoctorDto doctorDto);
    DoctorDto getDoctorById(Long id);
    List<DoctorDto> getDoctors();
    DoctorDto updateDoctor(Long id, DoctorDto doctorDto);
    void deleteDoctor(Long id);
}
