package ru.bellintegrator.practice.project.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.service.organization.OrganizationServiceImpl;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetListOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetOrganizationView;
import ru.bellintegrator.practice.project.view.organization.SaveOrganizationView;

import java.util.List;

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
    public GetOrganizationView orgGet(@PathVariable(name = "id") Integer id) {
        return organizationService.findOrg(id);
    }

    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST")
    @PostMapping("api/organization/save")
    public String organizationPost(@RequestBody SaveOrganizationView organization) {
        organizationService.save(organization);
        return "success";
    }

    @ApiOperation(value = "Обновить организацию", httpMethod = "POST")
    @PostMapping("api/organization/update")
    public String organizationUpdate(@RequestBody GetOrganizationView view) {
        organizationService.update(view);
        return "success";
    }

    @ApiOperation(value = "Поиск организации по фильтру", httpMethod = "POST")
    @PostMapping("api/organization/list")
    public List<GetListOrganizationView> organizationFind(@RequestBody FindOrganizationView findOrganizationView) {
        return organizationService.findBy(findOrganizationView);
    }
}
