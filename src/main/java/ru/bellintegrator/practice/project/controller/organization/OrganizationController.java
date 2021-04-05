package ru.bellintegrator.practice.project.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.service.organization.OrganizationServiceImpl;
import ru.bellintegrator.practice.project.view.OrganizationView;
import ru.bellintegrator.practice.project.model.Organization;

@RestController
@Api(value = "OrganizationController", description = "Управление информацией об организация")
public class OrganizationController {

    private final OrganizationServiceImpl organizationService;

    @Autowired
    public OrganizationController(OrganizationServiceImpl organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить организацию по идентификатору", httpMethod = "GET")
    @GetMapping("/api/organization/{id}")
    public Organization orgGet(@PathVariable(name = "id") Integer id) {

        return organizationService.findOrg(id);
    }

    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST")
    @PostMapping("api/organization/save")
    public String organizationPost(@RequestBody OrganizationView organization) {
        organizationService.saveOrg(organization);
        return "success";
    }


}
