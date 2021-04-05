package ru.bellintegrator.practice.project.service.documents;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.view.DocDictionaryView;

import javax.validation.Valid;

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
    DocDictionary findDoc(Integer code);

    /**
     * Добавить новое документ справочника
     *
     * @param dictionaryView
     */
    void saveDoc(@Valid DocDictionaryView dictionaryView);
    
}
