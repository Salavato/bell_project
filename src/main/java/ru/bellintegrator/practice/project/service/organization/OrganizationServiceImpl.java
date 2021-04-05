package ru.bellintegrator.practice.project.service.organization;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.organization.OrganizationDaoImpl;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.OrganizationView;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDaoImpl dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Organization findOrg(Integer id) {
        return dao.findOrganizationById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOrg(OrganizationView view) {

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        Organization organization = mapperFacade.map(view, Organization.class);

        dao.saveOrganization(organization);
    }
}
