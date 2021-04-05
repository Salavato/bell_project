package ru.bellintegrator.practice.project.service.user;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.User;
import ru.bellintegrator.practice.project.view.UserView;

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
    User findUser(Integer id);

    /**
     * Добавить нового сотрудников
     *
     * @param userView
     */
    void saveUser(@Valid UserView userView);

}
