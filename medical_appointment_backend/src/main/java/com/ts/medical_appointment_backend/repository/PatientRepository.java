package com.ts.medical_appointment_backend.repository;

import com.ts.medical_appointment_backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByNameAndLastName(String name, String lastName);
}
