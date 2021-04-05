package ru.bellintegrator.practice.project.service.office;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.office.OfficeDaoImpl;
import ru.bellintegrator.practice.project.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.OfficeView;

import javax.validation.Valid;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDaoImpl dao;
    private final OrganizationDao organizationDao;

    @Autowired
    public OfficeServiceImpl(OfficeDaoImpl dao, OrganizationDao organizationDao) {
        this.dao = dao;
        this.organizationDao = organizationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Office findOffice(Integer id) {
        return dao.findOfficeById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOffice(@Valid OfficeView view) {
        Organization organization = organizationDao.findOrganizationById(view.getOrgId());

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        Office office = mapperFacade.map(view, Office.class);
        office.setOrganization(organization);
        dao.saveOffice(office);
    }
}
