package com.ts.medical_appointment_backend.repository;

import com.ts.medical_appointment_backend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByNameAndLastname(String name, String lastname);
}
