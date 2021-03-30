package ru.bellintegrator.practice.project.dao.organization;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Organization findOrganizationById(Integer id) {
        return entityManager.find(Organization.class, id);
//        Query query = entityManager.createNamedQuery("Organization.findById");
//        query.setParameter(1, id);
//        Organization singleResult = (Organization) query.getSingleResult();
    }

    @Override
    public String saveOrganization(Organization organization) {
        entityManager.persist(organization);
        //    organizationRepository.save(organization);
        return "success2";
    }
}
