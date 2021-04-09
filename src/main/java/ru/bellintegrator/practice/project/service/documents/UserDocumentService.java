package ru.bellintegrator.practice.project.service.documents;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.view.documents.UserDocumentView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для Документов сотрудника
 */
@Validated
public interface UserDocumentService {

    /**
     * Получить список документов сотрудников
     *
     * @return {@UserDocument}
     */
    List<UserDocumentView> allUserDocument();

    /**
     * Обновить документ сотрудника
     *
     * @param userDocumentView
     */
    void updateUserDocument(@Valid UserDocumentView userDocumentView);
}
