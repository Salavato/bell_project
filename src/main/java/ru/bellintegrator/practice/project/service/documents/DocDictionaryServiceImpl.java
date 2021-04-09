package ru.bellintegrator.practice.project.service.documents;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.docements.DocDictionaryDaoImpl;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.view.documents.DocDictionaryView;

import javax.validation.Valid;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class DocDictionaryServiceImpl implements DocDictionaryService {

    public final DocDictionaryDaoImpl dao;
    private final MapperFacade mapperFacade;


    @Autowired
    public DocDictionaryServiceImpl(DocDictionaryDaoImpl dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<DocDictionaryView> all() {
        List<DocDictionary> all = dao.allDoc();
        return mapperFacade.mapAsList(all, DocDictionaryView.class);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(@Valid DocDictionaryView view) {
        DocDictionary docDictionary = new DocDictionary();
        docDictionary.setCode(view.getCode());
        docDictionary.setName(view.getName());
        dao.save(docDictionary);
    }
}
