package ru.bellintegrator.practice.project.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.OrganizationView;

import javax.validation.Valid;

/**
 * Сервис для организаций
 */
@Validated
public interface OrganizationService {

    /**
     * Получить организацию
     *
     * @return {@Organization}
     */
    Organization findOrg(Integer id);

    /**
     * Добавить новую организацию
     *
     * @param organizationView
     */
    void saveOrg(@Valid OrganizationView organizationView);

}
