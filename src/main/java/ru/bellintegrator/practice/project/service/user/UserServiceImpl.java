package ru.bellintegrator.practice.project.service.user;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.docements.UserDocumentDaoImpl;
import ru.bellintegrator.practice.project.dao.office.OfficeDaoImpl;
import ru.bellintegrator.practice.project.dao.user.UserDaoImpl;
import ru.bellintegrator.practice.project.exception.UserNotFoundException;
import ru.bellintegrator.practice.project.model.*;
import ru.bellintegrator.practice.project.repository.CountryRepository;
import ru.bellintegrator.practice.project.repository.DocRepository;
import ru.bellintegrator.practice.project.view.user.*;

import javax.validation.Valid;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDao;
    private final OfficeDaoImpl officeDao;
    private final CountryRepository countryRepository;
    private final DocRepository docRepository;
    private final UserDocumentDaoImpl userDocumentDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl, OfficeDaoImpl officeDao, CountryRepository countryRepository, DocRepository docRepository, UserDocumentDaoImpl userDocumentDao, MapperFacade mapperFacade) {
        this.userDao = userDaoImpl;
        this.officeDao = officeDao;
        this.countryRepository = countryRepository;
        this.docRepository = docRepository;
        this.userDocumentDao = userDocumentDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public GetUserView findUser(Integer id) {
        User user = userDao.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
        GetUserView getUserView = mapperFacade.map(user, GetUserView.class);
        CountryDictionary countryDictionary = user.getCountryDictionary();
        getUserView.setCitizenshipCode(countryDictionary.getCode());
        getUserView.setCitizenshipName(countryDictionary.getName());
        DocDictionary docDictionary = user.getUserDocument().getDocDictionary();
        getUserView.setDocName(docDictionary.getName());
        getUserView.setDocNumber(user.getUserDocument().getDocNumber());
        getUserView.setDocDate(user.getUserDocument().getDocDate());
        return getUserView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveUser(@Valid SaveUserView view) {
        Office office = officeDao.findOfficeById(view.getOfficeId());
        CountryDictionary countryDictionary = countryRepository.findById(view.getCitizenshipCode()).get();
        DocDictionary docDictionary = docRepository.findDocDictionaryByCode(view.getDocCode());
        UserDocument userDocument = mapperFacade.map(view, UserDocument.class);
        User user = mapperFacade.map(view, User.class);
        user.setOffice(office);
        user.setCountryDictionary(countryDictionary);
        user.setUserDocument(userDocument);
        userDocument.setUser(user);
        userDocument.setDocDictionary(docDictionary);
        userDao.saveUser(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(@Valid UpdateUserView view) {
        User user = userDao.findUserById(view.getId());
        Office office = officeDao.findOfficeById(view.getOfficeId());
        user.setOffice(office);
        user.setFirstName(view.getFirstName());
        user.setSecondName(view.getSecondName());
        user.setMiddleName(view.getMiddleName());
        user.setPosition(view.getMiddleName());
        user.setPhone(view.getPhone());
        UserDocument userDocument = userDocumentDao.findUserDocumentById(view.getId());
        DocDictionary docDictionary = docRepository.findDocDictionaryByCode(view.getDocCode());
        docDictionary.setName(view.getDocName());
        docDictionary.setCode(view.getDocCode());
        userDocument.setDocDictionary(docDictionary);
        userDocument.setDocNumber(view.getDocNumber());
        userDocument.setDocDate(view.getDocDate());
        user.setUserDocument(userDocument);
        CountryDictionary countryDictionary = countryRepository.findById(view.getCitizenshipCode()).get();
        countryDictionary.setCode(view.getCitizenshipCode());
        user.setCountryDictionary(countryDictionary);
        userDao.update(user);
    }

    @Override
    public GetListUserView findBy(@Valid FindUserView view) {
        User user = userDao.filter(view);
        return mapperFacade.map(user, GetListUserView.class);
    }
}
