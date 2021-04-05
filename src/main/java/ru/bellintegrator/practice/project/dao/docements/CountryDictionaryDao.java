package ru.bellintegrator.practice.project.dao.docements;

import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.model.Office;

/**
 * Data Access Object для работы с CountryDictionary
 */
public interface CountryDictionaryDao {

    /**
     * Получить CountryDictionary по идентификатору
     *
     * @param code
     * @return
     */
    CountryDictionary findCountryById(Integer code);


    /**
     * Сохранить CountryDictionary
     *
     * @param countryDictionary
     */
    void saveCountry(CountryDictionary countryDictionary);
}
