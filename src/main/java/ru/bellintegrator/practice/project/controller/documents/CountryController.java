package ru.bellintegrator.practice.project.controller.documents;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.service.documents.CountryDictionaryServiceImpl;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.documents.CountryDictionaryView;

import java.util.List;

@RestController
@Api(value = "CountryController", description = "Управление информацией о гражданствах")
public class CountryController {

    private final CountryDictionaryServiceImpl countryDictionaryService;

    @Autowired
    public CountryController(CountryDictionaryServiceImpl countryDictionaryService) {
        this.countryDictionaryService = countryDictionaryService;
    }

    @GetMapping("/api/country")
    @ApiOperation(value = "Получить список гражданств", httpMethod = "GET")
    public List<CountryDictionaryView> countryListGet() {
        return countryDictionaryService.allCountry();
    }

    @ApiOperation(value = "Добавить новое гражданство", httpMethod = "POST")
    @PostMapping("api/country/save")
    public void organizationPost(@RequestBody CountryDictionaryView view) {
        countryDictionaryService.add(view);
    }
}
