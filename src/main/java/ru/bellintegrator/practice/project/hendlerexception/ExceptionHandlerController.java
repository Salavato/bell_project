package ru.bellintegrator.practice.project.hendlerexception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.project.exception.OfficeNotFoundException;
import ru.bellintegrator.practice.project.exception.OrganizationNotFoundException;
import ru.bellintegrator.practice.project.exception.UserNotFoundException;
import ru.bellintegrator.practice.project.view.exception.ViewException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserNotFoundException.class)
    public ViewException userHandledException(UserNotFoundException e) {
        ViewException viewException = new ViewException();
        viewException.setMessage(e.getMessage());
        return viewException;
    }

    @ExceptionHandler(OfficeNotFoundException.class)
    public ViewException officeHandledException(OfficeNotFoundException e) {
        ViewException viewException = new ViewException();
        viewException.setMessage(e.getMessage());
        return viewException;
    }

    @ExceptionHandler(OrganizationNotFoundException.class)
    public ViewException organizationHandledException(OrganizationNotFoundException e) {
        ViewException viewException = new ViewException();
        viewException.setMessage(e.getMessage());
        return viewException;
    }



}


