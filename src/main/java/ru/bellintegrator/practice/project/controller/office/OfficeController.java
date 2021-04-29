package ru.bellintegrator.practice.project.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.service.office.OfficeServiceImpl;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.office.GetListOfficeView;
import ru.bellintegrator.practice.project.view.office.GetOfficeView;
import ru.bellintegrator.practice.project.view.office.SaveOfficeView;

import javax.validation.Valid;
import java.util.List;


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
    public GetOfficeView officeGet(@PathVariable(name = "id") Integer id) {
        return officeService.findOffice(id);
    }

    @PostMapping("api/office/save")
    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    public void officeSave(@Valid @RequestBody SaveOfficeView view) {
        officeService.saveOffice(view);
    }

    @ApiOperation(value = "Обновить офис", httpMethod = "POST")
    @PostMapping("api/office/update")
    public void officeUpdate(@RequestBody GetOfficeView view) {
        officeService.update(view);
    }

    @ApiOperation(value = "Поиск офиса по фильтру", httpMethod = "POST")
    @PostMapping("api/office/list")
    public List<GetListOfficeView> officeFind(@RequestBody FindOfficeView findOfficeView) {
        return officeService.findBy(findOfficeView);
    }
}
