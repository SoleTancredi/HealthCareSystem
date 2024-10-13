package com.ts.medical_appointment_backend.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SpecialityDto {
    @NotBlank(message = "Speciality name cannot be empty.")
    @Size(max = 50, message = "Speciality name cannot exceed 100 characters.")
    private String specialityName;

    @NotBlank(message = "Consulting room cannot be empty.")
    @Size(max = 50, message = "Consulting room name cannot exceed 50 characters.")
    private String consultingRoom;

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getConsultingRoom() {
        return consultingRoom;
    }

    public void setConsultingRoom(String consultingRoom) {
        this.consultingRoom = consultingRoom;
    }
}
