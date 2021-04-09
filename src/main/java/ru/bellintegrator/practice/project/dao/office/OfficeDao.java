package ru.bellintegrator.practice.project.dao.office;

import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;

import java.util.List;

/**
 * Data Access Object для работы с Office
 */
public interface OfficeDao {

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office findOfficeById(Integer id);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void saveOffice(Office office);

    /**
     * Обновить Office
     * @param office
     */
    void update(Office office);

    /**
     * Поиск Office по фильтру
     * @param view
     */
    List<Office> filter(FindOfficeView view);
}
