package com.ts.medical_appointment_backend.service.impl;

import com.ts.medical_appointment_backend.controller.dtos.DoctorDto;
import com.ts.medical_appointment_backend.entity.Doctor;
import com.ts.medical_appointment_backend.exceptions.DoctorNotFoundException;
import com.ts.medical_appointment_backend.repository.DoctorRepository;
import com.ts.medical_appointment_backend.service.DoctorService;
import com.ts.medical_appointment_backend.service.mapper.DoctorMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public Doctor createDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorDto.getName());
        doctor.setLastname(doctorDto.getLastname());
        doctor.setSpeciality(doctorDto.getSpeciality());

        return doctorRepository.save(doctor);
    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));

        return doctorMapper.toDto(doctor);
    }

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();

        return doctors;
    }

    @Override
    public DoctorDto updateDoctor(Long id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));

        if (doctor != null) {
            doctor.setName(doctorDto.getName());
            doctor.setLastname(doctorDto.getLastname());
            doctor.setSpeciality(doctorDto.getSpeciality());
        }

        Doctor updatedDoctor = doctorRepository.save(doctor);

        return doctorMapper.toDto(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));

        doctorRepository.delete(doctor);
    }
}
