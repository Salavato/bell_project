package ru.bellintegrator.practice.project.service.user;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.office.OfficeDaoImpl;
import ru.bellintegrator.practice.project.dao.user.UserDaoImpl;
import ru.bellintegrator.practice.project.model.*;
import ru.bellintegrator.practice.project.repository.CountryRepository;
import ru.bellintegrator.practice.project.repository.DocRepository;
import ru.bellintegrator.practice.project.view.UserView;

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

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl, OfficeDaoImpl officeDao, CountryRepository countryRepository, DocRepository docRepository) {
        this.userDao = userDaoImpl;
        this.officeDao = officeDao;
        this.countryRepository = countryRepository;
        this.docRepository = docRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public User findUser(Integer id) {
        return userDao.findUserById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveUser(@Valid UserView view) {
        Office office = officeDao.findOfficeById(view.getOfficeId());
        CountryDictionary countryDictionary = countryRepository.findById(view.getCitizenshipCode()).get();
        DocDictionary docDictionary = docRepository.findDocDictionaryByCode(view.getDocCode());

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        UserDocument userDocument = mapperFacade.map(view, UserDocument.class);
        User user = mapperFacade.map(view, User.class);
        user.setOffice(office);
        user.setCountryDictionary(countryDictionary);
        user.setUserDocument(userDocument);

        userDocument.setUser(user);
        userDocument.setDocDictionary(docDictionary);

        userDao.saveUser(user);
    }
}
