package ru.bellintegrator.practice.project.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetListOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetOrganizationView;
import ru.bellintegrator.practice.project.view.organization.SaveOrganizationView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для организаций
 */
@Validated
public interface OrganizationService {

    /**
     * Получить организацию по идентификатору
     *
     * @return {@GetOrganizationView}
     */
    DataView findOrg(Integer id);

    /**
     * Добавить новую организацию
     *
     * @param view
     */
    void save(@Valid SaveOrganizationView view);

    /**
     * Обновить организацию
     *
     * @param view
     */
    void update(@Valid GetOrganizationView view);

    /**
     * Поиск данных организаций по фильтру
     *
     * @param view
     */
    DataView findBy(@Valid FindOrganizationView view);
}
