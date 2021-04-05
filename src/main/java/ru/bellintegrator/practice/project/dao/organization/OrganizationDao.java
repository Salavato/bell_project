package ru.bellintegrator.practice.project.dao.organization;

import ru.bellintegrator.practice.project.model.Organization;

/**
 * Data Access Object для работы с Organization
 */
public interface OrganizationDao {

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization findOrganizationById(Integer id);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void saveOrganization(Organization organization);

}
