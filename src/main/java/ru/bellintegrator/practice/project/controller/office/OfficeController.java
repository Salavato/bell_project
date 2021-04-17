package ru.bellintegrator.practice.project.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.service.office.OfficeServiceImpl;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.office.GetListOfficeView;
import ru.bellintegrator.practice.project.view.office.GetOfficeView;
import ru.bellintegrator.practice.project.view.office.SaveOfficeView;

import javax.xml.crypto.Data;
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
    public DataView officeGet(@PathVariable(name = "id") Integer id) {
        return officeService.findOffice(id);
    }

    @PostMapping("api/office/save")
    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    public ResultView officePost(@RequestBody SaveOfficeView view) {
        officeService.saveOffice(view);
        return new ResultView();
    }

    @ApiOperation(value = "Обновить офис", httpMethod = "POST")
    @PostMapping("api/office/update")
    public ResultView officeUpdate(@RequestBody GetOfficeView view) {
        officeService.update(view);
        return new ResultView();
    }

    @ApiOperation(value = "Поиск офиса по фильтру", httpMethod = "POST")
    @PostMapping("api/office/list")
    public DataView officeFind(@RequestBody FindOfficeView findOfficeView) {
        return officeService.findBy(findOfficeView);
    }
}
