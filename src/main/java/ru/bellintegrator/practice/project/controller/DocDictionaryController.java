package ru.bellintegrator.practice.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.model.UserDocument;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class DocDictionaryController {

    @PersistenceContext
    private final EntityManager entityManager;

    public DocDictionaryController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/api/docdict/{id}")
    public DocDictionary userDocGet(@PathVariable(name = "id") Integer id) {
        Query query = entityManager.createNamedQuery("DocDictionary.findById");
        query.setParameter(1,id);
        return (DocDictionary) query.getSingleResult();
    }
}
