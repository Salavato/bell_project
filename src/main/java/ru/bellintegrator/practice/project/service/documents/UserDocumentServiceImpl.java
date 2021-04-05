package ru.bellintegrator.practice.project.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.docements.UserDocumentDaoImpl;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.UserDocumentView;

/**
 * {@inheritDoc}
 */
@Service
public class UserDocumentServiceImpl implements UserDocumentService {

    private final UserDocumentDaoImpl dao;

    @Autowired
    public UserDocumentServiceImpl(UserDocumentDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDocument findUserDocument(Integer id) {
        return dao.findUserDocumentById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateUserDocument(UserDocumentView view) {
        UserDocument document = dao.findUserDocumentById(view.getIdUser());
        document.setDocNumber("2А-1-У8");
        dao.updateUserDoc(document);
    }
}

