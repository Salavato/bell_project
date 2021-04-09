package ru.bellintegrator.practice.project.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    @Override
    public List<Organization> filter(FindOrganizationView view) {
        List<Predicate> predicateList = new ArrayList<>();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);
        Root<Organization> organization = criteria.from(Organization.class);
        Predicate predicateName = builder.equal(organization.get("name"), view.getName());
        predicateList.add(predicateName);
        if (view.getInn() != null) {
            Predicate predicateInn = builder.equal(organization.get("inn"), view.getInn());
            predicateList.add(predicateInn);
        }
        if (view.getIsActive() != null) {
            Predicate predicateisActive = builder.equal(organization.get("isActive"), view.getIsActive());
            predicateList.add(predicateisActive);
        }
        criteria.where(predicateList.toArray(new Predicate[predicateList.size()]));
        TypedQuery<Organization> query = em.createQuery(criteria);
        return query.getResultList();
    }
}
