package ru.bellintegrator.practice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.repository.CountryRepository;
import ru.bellintegrator.practice.project.repository.DocRepository;

@RestController
public class TestController {

    @Autowired
    private final CountryRepository countryRepository;
    @Autowired
    private final DocRepository docRepository;

    public TestController(CountryRepository countryRepository, DocRepository docRepository) {
        this.countryRepository = countryRepository;
        this.docRepository = docRepository;
    }

    @GetMapping("/adcountry")
    public void adCountryDict() {

        CountryDictionary countryDictionary = new CountryDictionary();
        countryDictionary.setName("Военный билет");

        countryRepository.save(countryDictionary);
    }

    @GetMapping("/addoc")
    public void adDocDict() {
        DocDictionary docDictionary = new DocDictionary();
        docDictionary.setCode(643);
        docDictionary.setName("Российская Федерация");

        docRepository.save(docDictionary);
    }


}
