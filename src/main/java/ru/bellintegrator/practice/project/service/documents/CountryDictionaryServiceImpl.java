package ru.bellintegrator.practice.project.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.docements.CountryDictionaryDaoImpl;
import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.view.CountryDictionaryView;

import javax.validation.Valid;

/**
 * {@inheritDoc}
 */
@Service
public class CountryDictionaryServiceImpl implements CountryDictionaryService {

    private final CountryDictionaryDaoImpl dao;

    @Autowired
    public CountryDictionaryServiceImpl(CountryDictionaryDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CountryDictionary findCountry(Integer code) {
        return dao.findCountryById(code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveCountry(@Valid CountryDictionaryView view) {
        CountryDictionary countryDictionary = new CountryDictionary();
        countryDictionary.setCode(view.getCode());
        countryDictionary.setName(view.getName());
        dao.saveCountry(countryDictionary);
    }

}
