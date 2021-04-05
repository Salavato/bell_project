package ru.bellintegrator.practice.project.controller.documents;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.repository.CountryRepository;
import ru.bellintegrator.practice.project.service.documents.CountryDictionaryServiceImpl;
import ru.bellintegrator.practice.project.view.CountryDictionaryView;

import java.util.List;

@RestController
@Api(value = "CountryController", description = "Управление информацией о гражданствах")
public class CountryController {

    private final CountryDictionaryServiceImpl countryDictionaryService;
    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryDictionaryServiceImpl countryDictionaryService, CountryRepository countryRepository) {
        this.countryDictionaryService = countryDictionaryService;
        this.countryRepository = countryRepository;
    }

    @GetMapping("/api/country")
    @ApiOperation(value = "Получить список гражданств", httpMethod = "GET")
    public List<CountryDictionary> countryListGet() {
        return countryRepository.findAll();
    }

    @ApiOperation(value = "Добавить новое гражданство", httpMethod = "POST")
    @PostMapping("api/country/save")
    public String organizationPost(@RequestBody CountryDictionaryView view) {
        countryDictionaryService.saveCountry(view);
        return "success";
    }
}
