package ru.bellintegrator.practice.project.dao.docements;

import ru.bellintegrator.practice.project.model.CountryDictionary;
import ru.bellintegrator.practice.project.model.DocDictionary;

/**
 * Data Access Object для работы с DocDictionary
 */
public interface DocDictionaryDao {

    /**
     * Получить DocDictionary по идентификатору
     *
     * @param code
     * @return
     */
    DocDictionary findDocById(Integer code);


    /**
     * Сохранить DocDictionary
     *
     * @param docDictionary
     */
    void saveDoc(DocDictionary docDictionary);
    
}
