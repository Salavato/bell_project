package ru.bellintegrator.practice.project.exception.hendlerexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.project.exception.NotFoundException;
import ru.bellintegrator.practice.project.view.exception.ViewException;

import java.util.List;
import java.util.UUID;

/**
 * ExceptionHandler для обработки exceptions
 */
@RestControllerAdvice
@Slf4j
@Order(value = 2)
public class ExceptionHandlerController {

    /**
     * Метод для обработки исключений
     */
    @ExceptionHandler(Throwable.class)
    public ViewException modelException(Throwable e) {
        String errorCode = UUID.randomUUID().toString();
        ViewException viewException = new ViewException();
        viewException.setMessage("Sorry internal error");
        log.error("ExceptionCode " + errorCode +" Message: "+ e.getMessage(), e);
        return viewException;
    }

    @ExceptionHandler(NotFoundException.class)
    public ViewException notFoundException(NotFoundException e) {
        ViewException viewException = new ViewException();
        viewException.setMessage(e.getMessage());
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


