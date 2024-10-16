package com.ts.medical_appointment_backend.service.impl;

import com.ts.medical_appointment_backend.controller.dtos.PatientDto;
import com.ts.medical_appointment_backend.entity.Patient;
import com.ts.medical_appointment_backend.exceptions.PatientAlreadyExistsException;
import com.ts.medical_appointment_backend.exceptions.PatientNotFoundException;
import com.ts.medical_appointment_backend.repository.PatientRepository;
import com.ts.medical_appointment_backend.service.PatientService;
import com.ts.medical_appointment_backend.service.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public Patient createPatient(PatientDto patientDto) {

        patientRepository.findByNameAndLastName(patientDto.getName(), patientDto.getLastName())
                .ifPresent(patient -> {
                    throw new PatientAlreadyExistsException("Patient with the same name and lastname already exists.");
                });

        Patient newPatient = new Patient();
        newPatient.setName(patientDto.getName());
        newPatient.setLastName(patientDto.getLastName());
        newPatient.setAge(patientDto.getAge());
        newPatient.setMail(patientDto.getMail());
        newPatient.setPhone(patientDto.getPhone());
        newPatient.setAddress(patientDto.getAddress());

        return patientRepository.save(newPatient);
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));

        return patientMapper.toDto(patient);
    }

    @Override
    public List<PatientDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(patientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));

        if (patient != null) {
            patient.setName(patientDto.getName());
            patient.setLastName(patientDto.getLastName());
        }

        assert patient != null;
        Patient updatedPatient = patientRepository.save(patient);

        return patientMapper.toDto(updatedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));

        patientRepository.delete(patient);
    }
}
