package ru.bellintegrator.practice.project.service.office;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.project.dao.office.OfficeDaoImpl;
import ru.bellintegrator.practice.project.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.project.exception.NotFoundException;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.office.GetListOfficeView;
import ru.bellintegrator.practice.project.view.office.GetOfficeView;
import ru.bellintegrator.practice.project.view.office.SaveOfficeView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDaoImpl dao;
    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;


    @Autowired
    public OfficeServiceImpl(OfficeDaoImpl dao, OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DataView findOffice(Integer id) {
        Office office = Optional.ofNullable(dao.findOfficeById(id))
                .orElseThrow(() -> new NotFoundException("Office with id: " + id + " not found"));
        GetOfficeView map = mapperFacade.map(office, GetOfficeView.class);
        return new DataView(map);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOffice(@Valid SaveOfficeView view) {
        Organization organization = Optional.ofNullable(organizationDao.findOrganizationById(view.getOrgId()))
                .orElseThrow(() -> new NotFoundException("Organization with id: " + view.getOrgId() + " not found"));
        Office office = mapperFacade.map(view, Office.class);
        office.setOrganization(organization);
        dao.saveOffice(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(@Valid GetOfficeView view) {
        Office office = Optional.ofNullable(dao.findOfficeById(view.getId()))
                .orElseThrow(() -> new NotFoundException("Office with id: " + view.getId() + " not found"));
        office.setId(view.getId());
        office.setName(view.getName());
        office.setAddress(view.getAddress());
        office.setPhone(view.getPhone());
        dao.update(office);
    }

    @Override
    public DataView findBy(@Valid FindOfficeView view) {
        List<Office> list = dao.filter(view);
        List<GetListOfficeView> map = mapperFacade.mapAsList(list, GetListOfficeView.class);
        return new DataView(map);
    }
}
