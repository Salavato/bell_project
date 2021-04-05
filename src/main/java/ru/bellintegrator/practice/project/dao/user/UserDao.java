package ru.bellintegrator.practice.project.dao.user;

import ru.bellintegrator.practice.project.model.User;

/**
 * Data Access Object для работы с User
 */
public interface UserDao {

    /**
     * Получить UserTable по идентификатору
     *
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * Сохранить UserTable
     *
     * @param office
     */
    void saveUser(User office);



}
