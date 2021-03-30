package ru.bellintegrator.practice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.view.OrganizationView;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.service.OrganizationService;

@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/api/organization/{id}")
    public Organization orgGet(@PathVariable(name = "id") Integer id) {
        return organizationService.findOrg(id);
    }

    @PostMapping("api/organization/save")
    public String organizationPost(@RequestBody OrganizationView organizationDao) {
        organizationService.saveOrg(organizationDao);
        return "success";
    }









}
