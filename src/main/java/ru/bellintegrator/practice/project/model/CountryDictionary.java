package ru.bellintegrator.practice.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@NamedNativeQuery(name = "CountryDictionary.findById",
        query = "SELECT * FROM country_dictionary WHERE code = ?1",
        resultClass = CountryDictionary.class)
public class CountryDictionary {

    /**
     * Код гражданства
     */
    @Id
    private Integer code;

    /**
     * Наименование гражданства
     */
    @Size(max = 50)
    private String name;

}
