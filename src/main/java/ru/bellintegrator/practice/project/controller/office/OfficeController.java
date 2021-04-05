package ru.bellintegrator.practice.project.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.service.office.OfficeServiceImpl;
import ru.bellintegrator.practice.project.view.OfficeView;


@RestController
@Api(value = "OfficeController", description = "Управление информацией об офисах")
public class OfficeController {

    public final OfficeServiceImpl officeService;

    @Autowired
    public OfficeController(OfficeServiceImpl officeServise) {
        this.officeService = officeServise;
    }

    @GetMapping("/api/office/{id}")
    @ApiOperation(value = "Получить офис по идентификатору", httpMethod = "GET")
    public Office officeGet(@PathVariable(name = "id") Integer id) {
        return officeService.findOffice(id);
    }

    @PostMapping("api/office/save")
    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    public String organizationPost(@RequestBody OfficeView view) {
        officeService.saveOffice(view);
        return "success";
    }

}
