package com.ts.medical_appointment_backend.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long patientId;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Date dateOfAppointment;
}
