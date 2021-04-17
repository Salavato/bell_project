package ru.bellintegrator.practice.project.service.documents;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.docements.CountryDictionaryDaoImpl;
import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.documents.CountryDictionaryView;

import javax.validation.Valid;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class CountryDictionaryServiceImpl implements CountryDictionaryService {

    private final CountryDictionaryDaoImpl dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountryDictionaryServiceImpl(CountryDictionaryDaoImpl dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public DataView allCountry() {
        List<CountryDictionary> all = dao.allCountry();
        List<CountryDictionaryView> map = mapperFacade.mapAsList(all, CountryDictionaryView.class);
        return new DataView(map);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(@Valid CountryDictionaryView view) {
        CountryDictionary countryDictionary = new CountryDictionary();
        countryDictionary.setCode(view.getCode());
        countryDictionary.setName(view.getName());
        dao.save(countryDictionary);
    }
}
