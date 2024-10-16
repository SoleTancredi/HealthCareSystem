package com.ts.medical_appointment_backend.exceptions;

public class PatientAlreadyExistsException extends RuntimeException {

    // Constructor que acepta un mensaje personalizado
    public PatientAlreadyExistsException(String message) {
        super(message);  // Pasa el mensaje a la clase base RuntimeException
    }

    // Constructor opcional que acepta tanto un mensaje como una causa (otra excepción)
    public PatientAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);  // Pasa el mensaje y la causa a RuntimeException
    }
}
