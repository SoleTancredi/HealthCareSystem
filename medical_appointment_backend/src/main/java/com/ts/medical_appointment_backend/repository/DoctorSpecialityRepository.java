package com.ts.medical_appointment_backend.repository;


import com.ts.medical_appointment_backend.entity.DoctorSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpeciality, Long> {

}
