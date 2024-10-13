package com.ts.medical_appointment_backend.entity;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)  // Does not allow null values in database column
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;
}
