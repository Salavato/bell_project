package ru.bellintegrator.practice.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.repository.OfficeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class OfficeController {

    @PersistenceContext
    private final EntityManager entityManager;
    private final OfficeRepository officeRepository;

    public OfficeController(EntityManager entityManager, OfficeRepository officeRepository) {
        this.entityManager = entityManager;
        this.officeRepository = officeRepository;
    }

    @GetMapping("/api/office/{id}")
    public Office officeGet(@PathVariable(name = "id") Integer id) {
        Query query = entityManager.createNamedQuery("Office.findById");
        query.setParameter(1,id);
        return (Office) query.getSingleResult();
    }

    @GetMapping("/api/office/test/{id}")
    public Office officeGetTest(@PathVariable(name = "id") Integer id) {
        return officeRepository.findById(id).get();
    }




}
