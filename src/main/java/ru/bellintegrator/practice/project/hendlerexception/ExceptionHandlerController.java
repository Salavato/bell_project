package ru.bellintegrator.practice.project.hendlerexception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.project.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> unhandledException(UserNotFoundException e) {
        Map<String, String> mapError = new HashMap<>();
        mapError.put("error", e.getMessage());
        return mapError;
    }




}


