package ru.bellintegrator.practice.project.dao.organization;

import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;

import java.util.List;

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
    void save(Organization organization);

    /**
     * Обновить Organization
     * @param organization
     */
    void update(Organization organization);

    /**
     * Поиск Organization по фильтру
     * @param view
     */
    List<Organization> filter(FindOrganizationView view);
}
