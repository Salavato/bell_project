package ru.bellintegrator.practice.project.dao.docements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.CountryDictionary;

import javax.persistence.EntityManager;


/**
 * {@inheritDoc}
 */
@Repository
public class CountryDictionaryDaoImpl implements CountryDictionaryDao {

    private final EntityManager em;

    @Autowired
    public CountryDictionaryDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryDictionary findCountryById(Integer code) {

        return em.find(CountryDictionary.class, code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveCountry(CountryDictionary country) {
        em.persist(country);
    }
}
