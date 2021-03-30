package ru.bellintegrator.practice.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.model.DocDictionary;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;

@RestController
public class CountryController {

    private final EntityManager entityManager;

    public CountryController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/api/country/{id}")
    public CountryDictionary userDocGet(@PathVariable(name = "id") Integer id) {
        Query query = entityManager.createNamedQuery("CountryDictionary.findById");
        query.setParameter(1,id);
        return (CountryDictionary) query.getSingleResult();
    }
}
