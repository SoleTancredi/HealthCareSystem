package com.ts.medical_appointment_backend.repository;

import com.ts.medical_appointment_backend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorIdAndDateTimeAppointment(Long doctorId, Date dateTimeAppointment);


}
