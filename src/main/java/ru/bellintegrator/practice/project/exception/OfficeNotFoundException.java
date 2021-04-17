package ru.bellintegrator.practice.project.exception;

public class OfficeNotFoundException extends RuntimeException{

    public OfficeNotFoundException(String message) {
        super(message);
    }
}
