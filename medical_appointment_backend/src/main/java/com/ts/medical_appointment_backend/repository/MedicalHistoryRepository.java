package com.ts.medical_appointment_backend.repository;

import com.ts.medical_appointment_backend.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}
