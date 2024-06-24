package com.springlesson.clinicadmin.examples.exception;

public class ShelterException extends Exception{
    public ShelterException(String message) {
        super(message);
    }

    public ShelterException(String message, Throwable cause) {
        super(message, cause);
    }
}
