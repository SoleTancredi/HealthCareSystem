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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Date getDateTimeAppointment() {
        return dateTimeAppointment;
    }

    public void setDateTimeAppointment(Date dateTimeAppointment) {
        this.dateTimeAppointment = dateTimeAppointment;
    }
}
