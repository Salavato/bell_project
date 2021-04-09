package ru.bellintegrator.practice.project.dao.docements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.CountryDictionary;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public List<CountryDictionary> allCountry() {
        TypedQuery<CountryDictionary> query =
                em.createQuery("SELECT c FROM CountryDictionary c", CountryDictionary.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(CountryDictionary country) {
        em.persist(country);
    }
}
