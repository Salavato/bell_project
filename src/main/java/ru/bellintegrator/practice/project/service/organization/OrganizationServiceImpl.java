package ru.bellintegrator.practice.project.service.organization;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.organization.OrganizationDaoImpl;
import ru.bellintegrator.practice.project.exception.NotFoundException;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetListOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetOrganizationView;
import ru.bellintegrator.practice.project.view.organization.SaveOrganizationView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 */
@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDaoImpl dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDaoImpl dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DataView findOrg(Integer id) {
        Organization organization = Optional.ofNullable(dao.findOrganizationById(id))
                .orElseThrow(() -> new NotFoundException("Organization with id: " + id + " not found"));
        GetOrganizationView map = mapperFacade.map(organization, GetOrganizationView.class);
        return new DataView(map);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(SaveOrganizationView view) {
        Organization organization = mapperFacade.map(view, Organization.class);
        dao.save(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(GetOrganizationView view) {
        Organization organization = Optional.ofNullable(dao.findOrganizationById(view.getId()))
                .orElseThrow(() -> new NotFoundException("Organization with id: " + view.getId() + " not found"));
        organization.setId(view.getId());
        organization.setName(view.getName());
        organization.setFullName(view.getFullName());
        organization.setInn(view.getInn());
        organization.setKpp(view.getKpp());
        organization.setAddress(view.getAddress());
        dao.update(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView findBy(@Valid FindOrganizationView view) {
        List<Organization> list = Optional.ofNullable(dao.filter(view))
                .orElseThrow(() -> new NotFoundException(view.getName() + "Not found"));
        List<GetListOrganizationView> map = mapperFacade.mapAsList(list, GetListOrganizationView.class);
        return new DataView(map);
    }
}
