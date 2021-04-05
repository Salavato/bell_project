package ru.bellintegrator.practice.project.dao.docements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.UserDocument;
import javax.persistence.EntityManager;

@Repository
public class UserDocumentDaoImpl implements UserDocumentDao {

    public final EntityManager em;

    @Autowired
    public UserDocumentDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public UserDocument findUserDocumentById(Integer id) {
        return em.find(UserDocument.class, id);
    }

    @Override
    public void updateUserDoc(UserDocument userDocument) {
        em.merge(userDocument);
    }
}
