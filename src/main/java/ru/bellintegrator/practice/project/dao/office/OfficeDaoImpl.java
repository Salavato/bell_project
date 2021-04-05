package ru.bellintegrator.practice.project.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.Office;

import javax.persistence.EntityManager;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {


    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office findOfficeById(Integer id) {

        return em.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }
}
