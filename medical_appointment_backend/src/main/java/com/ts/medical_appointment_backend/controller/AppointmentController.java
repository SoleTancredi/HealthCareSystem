package com.ts.medical_appointment_backend.controller;

import com.ts.medical_appointment_backend.controller.dtos.AppointmentDto;
import com.ts.medical_appointment_backend.entity.Appointment;
import com.ts.medical_appointment_backend.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
        Appointment appointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointment.getId()), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(  @PathVariable Long id) {
        AppointmentDto appointmentDto = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointmentDto);
    }



    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments() {
        List<Appointment> appointments = appointmentService.getAppointments();
        return ResponseEntity.ok(appointments);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment( @PathVariable Long id,
                                                                 @Valid @RequestBody AppointmentDto appointmentDto) {
        AppointmentDto updatedAppointment = appointmentService.updateAppointment(id, appointmentDto);
        return ResponseEntity.ok(updatedAppointment);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment( @PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
