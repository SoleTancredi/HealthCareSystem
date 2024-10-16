package com.ts.medical_appointment_backend.service;

import com.ts.medical_appointment_backend.controller.dtos.PatientDto;
import com.ts.medical_appointment_backend.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(PatientDto paientDto);
    PatientDto getPatientById(Long id);
    List<PatientDto> getPatients();
    PatientDto updatePatient(Long id, PatientDto patientDto);
    void deletePatient(Long id);
}
