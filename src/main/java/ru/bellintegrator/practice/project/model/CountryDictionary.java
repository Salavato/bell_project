package ru.bellintegrator.practice.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Класс служит для хранения гражданств
 * @author Salavat
 * @version 1.0
 */

@Entity
@Table(name = "country_dictionary")
@Getter
@Setter
@NoArgsConstructor
public class CountryDictionary {

    /**
     * Код гражданства
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * Наименование гражданства
     */
    @Size(max = 50)
    private String name;

    /**
     * Поле для связи с сотрудниками
     */
    @OneToMany(mappedBy = "countryDictionary")
    private List<UserTable> userTableList;
}
