package ru.bellintegrator.practice.project.dao.docements;

import ru.bellintegrator.practice.project.model.CountryDictionary;

import java.util.List;

/**
 * Data Access Object для работы с CountryDictionary
 */
public interface CountryDictionaryDao {

    /**
     * Получить все объекты CountryDictionary
     *
     * @return
     */
    List<CountryDictionary> allCountry();

    /**
     * Сохранить CountryDictionary
     *
     * @param countryDictionary
     */
    void save(CountryDictionary countryDictionary);
}
