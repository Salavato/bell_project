package ru.bellintegrator.practice.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

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
public class DocDictionary {

    /**
     * Код документа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;

    /**
     * Наименование документа
     */
    @Column
    @Size(max = 50)
    private String name;

    /**
     * Поле для связи с документами
     */
    @OneToMany(mappedBy = "docDictionary")
    private List<UserDocument> userDocumentList;
}
