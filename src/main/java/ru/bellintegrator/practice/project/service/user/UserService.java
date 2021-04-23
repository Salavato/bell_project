package ru.bellintegrator.practice.project.service.user;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.user.*;

import javax.validation.Valid;

/**
 * Сервис для сотрудника
 */
@Validated
public interface UserService {

    /**
     * Получить сотрудника
     *
     * @return {@UserTable}
     */
    DataView findUser(Integer id);

    /**
     * Добавить нового сотрудников
     *
     * @param getUserView
     */
    void saveUser(@Valid SaveUserView getUserView);

    /**
     * Обновить сотрудника
     *
     * @param view
     */
    void update(@Valid UpdateUserView view);

    /**
     * Поиск данных по сотрудникам по фильтру
     *
     * @param view
     */
    DataView findBy(@Valid FindUserView view);

}
