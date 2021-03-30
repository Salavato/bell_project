package ru.bellintegrator.practice.project.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.project.dao.organization.OrganizationDaoImpl;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.OrganizationView;

import javax.transaction.Transactional;

@Service
public class OrganizationService {

    @Autowired
    private final OrganizationDaoImpl organizationDao;

    public OrganizationService(OrganizationDaoImpl organizationDao) {
        this.organizationDao = organizationDao;
    }

    public Organization findOrg(Integer id) {
        return organizationDao.findOrganizationById(id);
    }

    @Transactional
    public void saveOrg(OrganizationView organizationView) {
        Organization organization = new Organization();
        organization.setFullName(organizationView.getFullName());
        organization.setName(organizationView.getName());
        organization.setInn(organizationView.getInn());
        organization.setKpp(organizationView.getKpp());
        organization.setAddress(organizationView.getAddress());
        organizationDao.saveOrganization(organization);
    }

}
