package com.ts.medical_appointment_backend.controller;

import com.ts.medical_appointment_backend.entity.Speciality;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialityController {

    @GetMapping("/api/specialities")
    public List<String> getSpecialities() {
        return Speciality.getAllSpecialities();
    }
}
