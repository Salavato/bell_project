package ru.bellintegrator.practice.project.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.model.User;
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
    public User filter(FindUserView view) {
        List<Predicate> predicateList = new ArrayList<>();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> userRoot = criteria.from(User.class);
        Join<User, Office> join = userRoot.join("office");
        join.on(builder.equal(userRoot.get("office"), join.get("id")));
        Predicate predicateName = builder.equal(userRoot.get("id"), view.getOfficeId());
        predicateList.add(predicateName);
        criteria.where(predicateList.toArray(new Predicate[predicateList.size()]));

        TypedQuery<User> query = em.createQuery(criteria);
        return query.getSingleResult();
    }
}
