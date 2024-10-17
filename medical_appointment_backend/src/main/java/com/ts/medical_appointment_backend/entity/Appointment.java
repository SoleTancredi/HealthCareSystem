package com.ts.medical_appointment_backend.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @Column(nullable = false)
    private Date dateTimeAppointment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDateTimeAppointment() {
        return dateTimeAppointment;
    }

    public void setDateTimeAppointment(Date dateTimeAppointment) {
        this.dateTimeAppointment = dateTimeAppointment;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + (doctor != null ? doctor.getName() + " " + doctor.getLastname() : "No Doctor") +
                ", patient=" + (patient != null ? patient.getName() + " " + patient.getLastName() : "No Patient") +
                ", dateTimeAppointment=" + dateTimeAppointment +
                '}';
    }
}
