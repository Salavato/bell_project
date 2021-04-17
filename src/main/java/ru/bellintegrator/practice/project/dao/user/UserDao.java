package ru.bellintegrator.practice.project.dao.user;

import ru.bellintegrator.practice.project.model.Office;
import ru.bellintegrator.practice.project.model.User;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.user.FindUserView;

import java.util.List;

/**
 * Data Access Object для работы с User
 */
public interface UserDao {

    /**
     * Получить User по идентификатору
     *
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * Сохранить User
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * Обновить User
     * @param user
     */
    void update(User user);

    /**
     * Поиск User по фильтру
     * @param view
     */
    List<User> filter(FindUserView view);
}
