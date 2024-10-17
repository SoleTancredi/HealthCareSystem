package com.ts.medical_appointment_backend.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Speciality {
    CARDIOLOGY,
    DERMATOLOGY,
    NEUROLOGY,
    PEDIATRICS,
    PSYCHIATRY;

    public static List<String> getAllSpecialities() {
        return Arrays.stream(values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
