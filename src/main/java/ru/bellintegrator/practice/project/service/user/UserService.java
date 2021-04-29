package ru.bellintegrator.practice.project.service.user;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.view.user.*;

import javax.validation.Valid;
import java.util.List;

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
    GetUserView findUser(Integer id);

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
    List<GetListUserView> findBy(@Valid FindUserView view);

}
