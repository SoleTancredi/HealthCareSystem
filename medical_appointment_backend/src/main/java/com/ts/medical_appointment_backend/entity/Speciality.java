package com.ts.medical_appointment_backend.entity;

import jakarta.persistence.*;

@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String specialityName;
    @Column(nullable = false)
    private String consultingRoom;
}
