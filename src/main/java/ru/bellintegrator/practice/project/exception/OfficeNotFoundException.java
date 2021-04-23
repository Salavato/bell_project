package ru.bellintegrator.practice.project.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OfficeNotFoundException extends RuntimeException{

    public OfficeNotFoundException(String message) {
        super(message);
    }


}
