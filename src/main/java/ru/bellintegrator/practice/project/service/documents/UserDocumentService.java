package ru.bellintegrator.practice.project.service.documents;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.UserDocumentView;

import javax.validation.Valid;

/**
 * Сервис для Документов сотрудника
 */
@Validated
public interface UserDocumentService {

        /**
         * Получить документ сотрудника
         *
         * @return {@UserDocument}
         */
        UserDocument findUserDocument(Integer id);

        /**
         * Обновить документ сотрудника
         *
         * @param userDocumentView
         */
        void updateUserDocument(@Valid UserDocumentView userDocumentView);

}
