package ru.bellintegrator.practice.project.service.office;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.office.GetOfficeView;
import ru.bellintegrator.practice.project.view.office.SaveOfficeView;

import javax.validation.Valid;

/**
 * Сервис для офисов
 */
@Validated
public interface OfficeService {

    /**
     * Получить офис
     *
     * @return {@Office}
     */
    DataView findOffice(Integer id);

    /**
     * Добавить новый офис
     *
     * @param officeView
     */
    void saveOffice(@Valid SaveOfficeView officeView);

    /**
     * Обновить офис
     *
     * @param view
     */
    void update(@Valid GetOfficeView view);

    /**
     * Поиск данных офиса по фильтру
     *
     * @param view
     */
    DataView findBy(@Valid FindOfficeView view);
}
