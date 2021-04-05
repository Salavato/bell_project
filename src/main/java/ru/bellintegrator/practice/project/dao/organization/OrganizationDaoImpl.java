package ru.bellintegrator.practice.project.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.Organization;

import javax.persistence.EntityManager;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization findOrganizationById(Integer id) {
        return em.find(Organization.class, id);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOrganization(Organization organization) {
        em.persist(organization);
    }
}
