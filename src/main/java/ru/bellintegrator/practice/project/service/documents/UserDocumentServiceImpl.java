package ru.bellintegrator.practice.project.service.documents;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.docements.UserDocumentDaoImpl;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.documents.UserDocumentView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class UserDocumentServiceImpl implements UserDocumentService {

    private final UserDocumentDaoImpl dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserDocumentServiceImpl(UserDocumentDaoImpl dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDocumentView> allUserDocument() {
        List<UserDocument> all = dao.allUserDocument();
        return mapperFacade.mapAsList(all, UserDocumentView.class);
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

