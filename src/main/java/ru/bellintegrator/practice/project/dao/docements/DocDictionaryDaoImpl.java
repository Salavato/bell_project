package ru.bellintegrator.practice.project.dao.docements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.model.DocDictionary;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.print.Doc;
import java.util.List;

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
    public List<DocDictionary> allDoc() {
        TypedQuery<DocDictionary> query =
                em.createQuery("SELECT d FROM DocDictionary d", DocDictionary.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(DocDictionary docDictionary) {
        em.persist(docDictionary);
    }
}
