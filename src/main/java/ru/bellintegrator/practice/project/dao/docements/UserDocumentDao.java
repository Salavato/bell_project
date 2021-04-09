package ru.bellintegrator.practice.project.dao.docements;

import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.documents.UserDocumentView;

import java.util.List;

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
     * Получить полный список UserDocument
     * @param
     */
    List<UserDocument> allUserDocument();

    /**
     * Обновить UserDocument
     * @param userDocument
     */
    void updateUserDoc(UserDocument userDocument);
}
