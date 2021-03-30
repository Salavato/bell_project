package ru.bellintegrator.practice.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.UserTable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class UserController {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/api/user/{id}")
    public UserTable userGet(@PathVariable(name = "id") Integer id) {
        Query query = entityManager.createNamedQuery("UserTable.findById");
        query.setParameter(1,id);
        return (UserTable) query.getSingleResult();
    }

}
