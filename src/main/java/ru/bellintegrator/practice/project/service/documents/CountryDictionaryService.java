package ru.bellintegrator.practice.project.service.documents;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.view.CountryDictionaryView;
import ru.bellintegrator.practice.project.view.OfficeView;

import javax.validation.Valid;

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
    CountryDictionary findCountry(Integer code);

    /**
     * Добавить новое гражданство
     *
     * @param countryView
     */
    void saveCountry(@Valid CountryDictionaryView countryView);


}
