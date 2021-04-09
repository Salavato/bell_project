package ru.bellintegrator.practice.project.dao.docements;

import ru.bellintegrator.practice.project.model.DocDictionary;

import java.util.List;

/**
 * Data Access Object для работы с DocDictionary
 */
public interface DocDictionaryDao {

    /**
     * Получить все объекты DocDictionary
     *
     * @return
     */
    List<DocDictionary> allDoc();

    /**
     * Сохранить DocDictionary
     *
     * @param docDictionary
     */
    void save(DocDictionary docDictionary);
}
