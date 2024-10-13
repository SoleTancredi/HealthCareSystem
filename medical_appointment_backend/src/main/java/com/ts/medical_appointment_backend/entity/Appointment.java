package com.ts.medical_appointment_backend.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long doctorId;
    @Column(nullable = false)
    private Long patientId;
    @Column(nullable = false)
    private Date dateTimeAppointment;
}
