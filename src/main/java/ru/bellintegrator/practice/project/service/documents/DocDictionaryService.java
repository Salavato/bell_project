package ru.bellintegrator.practice.project.service.documents;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.view.documents.DocDictionaryView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для справочников документов
 */
@Validated
public interface DocDictionaryService {

    /**
     * Получить документ справочника
     *
     * @return {@DocDictionary}
     */
    List<DocDictionaryView> all();

    /**
     * Добавить новое документ справочника
     *
     * @param dictionaryView
     */
    void save(@Valid DocDictionaryView dictionaryView);
}
