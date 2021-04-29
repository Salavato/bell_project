package ru.bellintegrator.practice.project.service.documents;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.view.documents.CountryDictionaryView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для гражданств
 */
@Validated
public interface CountryDictionaryService {

    /**
     * Получить гражданство
     *
     * @return {@CountryDictionary}
     */
    List<CountryDictionaryView> allCountry();


    /**
     * Добавить новое гражданство
     *
     * @param countryView
     */
    void add(@Valid CountryDictionaryView countryView);

}
