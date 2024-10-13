package com.ts.medical_appointment_backend.entity;

import jakarta.persistence.*;

@Entity
public class DoctorSpeciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long doctorId;
    @Column(nullable = false)
    private Long specialityId;
}
