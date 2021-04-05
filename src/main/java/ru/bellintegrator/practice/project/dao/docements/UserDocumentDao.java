package ru.bellintegrator.practice.project.dao.docements;

import ru.bellintegrator.practice.project.model.UserDocument;

/**
 * Data Access Object для работы с CountryDictionary
 */
public interface UserDocumentDao {

    /**
     * Получить UserDocument по идентификатору
     * @param id
     * @return
     */
    UserDocument findUserDocumentById(Integer id);

    /**
     * Обновить UserDocument
     * @param userDocument
     */
    void updateUserDoc(UserDocument userDocument);

}
