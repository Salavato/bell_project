package ru.bellintegrator.practice.project.service.office;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.office.GetListOfficeView;
import ru.bellintegrator.practice.project.view.office.GetOfficeView;
import ru.bellintegrator.practice.project.view.office.SaveOfficeView;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetOrganizationView;

import javax.validation.Valid;
import java.util.List;

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
    GetOfficeView findOffice(Integer id);

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
    List<GetListOfficeView> findBy(@Valid FindOfficeView view);
}
