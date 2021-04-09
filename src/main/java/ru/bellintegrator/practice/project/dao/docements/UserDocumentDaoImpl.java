package ru.bellintegrator.practice.project.dao.docements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.documents.UserDocumentView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public List<UserDocument> allUserDocument() {
        TypedQuery<UserDocument> query =
                em.createQuery("SELECT u FROM UserDocument u", UserDocument.class);
        return query.getResultList();
    }

    @Override
    public void updateUserDoc(UserDocument userDocument) {
        em.merge(userDocument);
    }
}
