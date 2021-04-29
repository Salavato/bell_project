package ru.bellintegrator.practice.project.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Office office) {
        em.merge(office);
    }

    @Override
    public List<Office> filter(FindOfficeView view) {
        List<Predicate> predicateList = new ArrayList<>();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);

        Root<Office> officeRoot = criteria.from(Office.class);
   //     Join<Office, Organization> join = officeRoot.join("organization");
        Predicate id = builder.equal(officeRoot.get("id"), view.getOrgId());
        predicateList.add(id);

        if (view.getName() != null) {
            Predicate name = builder.equal(officeRoot.get("name"), view.getName());
            predicateList.add(name);
        }

        if (view.getPhone() != null) {
            Predicate phone = builder.equal(officeRoot.get("phone"), view.getPhone());
            predicateList.add(phone);
        }

        if (view.getIsActive() != null) {
            Predicate isActive = builder.equal(officeRoot.get("isActive"), view.getIsActive());
            predicateList.add(isActive);
        }

        criteria.where(predicateList.toArray(new Predicate[predicateList.size()]));
        TypedQuery<Office> query = em.createQuery(criteria);
        return query.getResultList();
    }
}
