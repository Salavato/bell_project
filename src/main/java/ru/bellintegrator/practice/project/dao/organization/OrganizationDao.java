package ru.bellintegrator.practice.project.dao.organization;

import ru.bellintegrator.practice.project.view.OrganizationView;
import ru.bellintegrator.practice.project.model.Organization;

public interface OrganizationDao {

    Organization findOrganizationById(Integer id);

    String saveOrganization(Organization organization);

}
