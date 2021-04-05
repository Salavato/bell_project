package ru.bellintegrator.practice.project.service.office;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.view.OfficeView;

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
    Office findOffice(Integer id);

    /**
     * Добавить новый офис
     *
     * @param officeView
     */
    void saveOffice(@Valid OfficeView officeView);

}
