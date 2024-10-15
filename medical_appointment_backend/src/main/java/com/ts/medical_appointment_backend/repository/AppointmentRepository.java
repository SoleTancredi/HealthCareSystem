package com.ts.medical_appointment_backend.repository;

import com.ts.medical_appointment_backend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
