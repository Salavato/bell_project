package ru.bellintegrator.practice.project.dao.docements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.DocDictionary;

import javax.persistence.EntityManager;

/**
 * {@inheritDoc}
 */
@Repository
public class DocDictionaryDaoImpl implements DocDictionaryDao {

    private final EntityManager em;

    @Autowired
    public DocDictionaryDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocDictionary findDocById(Integer code) {
        return em.find(DocDictionary.class, code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDoc(DocDictionary docDictionary) {
        em.persist(docDictionary);
    }
}
