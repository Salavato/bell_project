package ru.bellintegrator.practice.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.project.exception.UserNotFoundException;

@RestController
public class TestController {

    @GetMapping("/testmap")
    public void testMap()  {
        throw new UserNotFoundException("This User not exist");
    }

}
