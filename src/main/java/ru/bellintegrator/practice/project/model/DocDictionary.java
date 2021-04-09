package ru.bellintegrator.practice.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Класс служит для хранения справочника документов
 * @author Salavat
 * @version 1.0
 */

@Entity
@Table(name = "doc_dictionary")
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(name = "DocDictionary.findById",
        query = "SELECT * FROM doc_dictionary WHERE code = ?1",
        resultClass = DocDictionary.class)
public class DocDictionary {

    /**
     * Код документа
     */
    @Id
    @Column(name = "code")
    private Integer code;

    /**
     * Наименование документа
     */
    @Column
    @Size(max = 50)
    private String name;
}
