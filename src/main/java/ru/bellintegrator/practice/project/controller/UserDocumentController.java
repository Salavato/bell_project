package ru.bellintegrator.practice.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.model.UserTable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class UserDocumentController {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDocumentController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/api/userdoc/{id}")
    public UserDocument userDocGet(@PathVariable(name = "id") Integer id) {
        Query query = entityManager.createNamedQuery("UserDocument.findById");
        query.setParameter(1,id);
        return (UserDocument) query.getSingleResult();
    }
}
