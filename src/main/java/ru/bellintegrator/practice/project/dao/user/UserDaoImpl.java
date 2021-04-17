package ru.bellintegrator.practice.project.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.*;
import ru.bellintegrator.practice.project.view.user.FindUserView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findUserById(Integer id) {
        return em.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public List<User> filter(FindUserView view) {
        List<Predicate> predicateList = new ArrayList<>();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> userRoot = criteria.from(User.class);
     //   Join<User, Office> joinOffice = userRoot.join("office");

        Predicate predicateOffice = builder.equal(userRoot.get("office"), view.getOfficeId());
        predicateList.add(predicateOffice);

        if (view.getFirstName() != null) {
            Predicate firstName = builder.equal(userRoot.get("firstName"), view.getFirstName());
            predicateList.add(firstName);
        }

        if (view.getSecondName() != null) {
            Predicate secondName = builder.equal(userRoot.get("secondName"), view.getSecondName());
            predicateList.add(secondName);
        }

        if (view.getMiddleName() != null) {
            Predicate middleName = builder.equal(userRoot.get("middleName"), view.getMiddleName());
            predicateList.add(middleName);
        }

        if (view.getPosition() != null) {
            Predicate position = builder.equal(userRoot.get("position"), view.getPosition());
            predicateList.add(position);
        }

        if (view.getCitizenshipCode() != null) {
            Join<User, CountryDictionary> joinCountryDictionary = userRoot.join("countryDictionary");
            Predicate countryCode = builder.equal(joinCountryDictionary.get("code"), view.getCitizenshipCode());
            predicateList.add(countryCode);
        }

        if (view.getDocCode() != null) {
            Join<User, UserDocument> joinUserDocument = userRoot.join("userDocument");
            Join<UserDocument, DocDictionary> joinDocDictionary = joinUserDocument.join("docDictionary");
            Predicate docCode = builder.equal(joinDocDictionary.get("code"), view.getDocCode());
            predicateList.add(docCode);
        }

        criteria.where(predicateList.toArray(new Predicate[predicateList.size()]));

        TypedQuery<User> query = em.createQuery(criteria);
        return query.getResultList();
    }

}
