package com.ts.medical_appointment_backend.repository;


import com.ts.medical_appointment_backend.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRespository extends JpaRepository<Speciality, Long> {
}
