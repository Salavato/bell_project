package ru.bellintegrator.practice.project.dao.office;

import ru.bellintegrator.practice.project.model.Office;

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
}
