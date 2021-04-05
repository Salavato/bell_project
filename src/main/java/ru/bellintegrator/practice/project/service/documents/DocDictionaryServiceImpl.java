package ru.bellintegrator.practice.project.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.docements.DocDictionaryDaoImpl;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.view.DocDictionaryView;

import javax.validation.Valid;

/**
 * {@inheritDoc}
 */
@Service
public class DocDictionaryServiceImpl implements DocDictionaryService {

    public final DocDictionaryDaoImpl dao;

    @Autowired
    public DocDictionaryServiceImpl(DocDictionaryDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DocDictionary findDoc(Integer code) {
        return dao.findDocById(code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveDoc(@Valid DocDictionaryView view) {
        DocDictionary docDictionary = new DocDictionary();
        docDictionary.setCode(view.getCode());
        docDictionary.setName(view.getName());
        dao.saveDoc(docDictionary);
    }
}
