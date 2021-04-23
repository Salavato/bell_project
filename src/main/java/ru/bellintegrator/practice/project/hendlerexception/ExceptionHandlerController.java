package ru.bellintegrator.practice.project.hendlerexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.project.view.exception.ViewException;

import java.util.List;

/**
 * ExceptionHandler для обработки exceptions
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    /**
     * Метод для обработки исключений
     */
    @ExceptionHandler(Exception.class)
    public ViewException modelException(Exception e) {
        ViewException viewException = new ViewException();
        viewException.setMessage(e.getMessage());
     //   log.error("Error " + e.getMessage());
        return viewException;
    }

    /**
     * Метод для обработки исключения валидации
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ViewException validExc(MethodArgumentNotValidException e) {
        ViewException viewException = new ViewException();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMes = "";
        for (FieldError fieldError : fieldErrors)
            errorMes += fieldError.getDefaultMessage() + "; ";
        viewException.setMessage(errorMes);
        return viewException;
    }
}


