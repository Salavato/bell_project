package ru.bellintegrator.practice.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Класс служит для хранения сотрудников
 * @author Salavat
 * @version 1.0
 */

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    /**
     * Служебное поле hibernate
     */
    @NotNull
    @Version
    public Integer version;

    /**
     * Имя сотрудника
     */
    @Column(nullable = false)
    @Size(max = 100)
    public String first_name;

    /**
     * Фамилия сотрудника
     */
    @Column(nullable = false)
    @Size(max = 100)
    public String second_name;

    /**
     * Отчество сотрудника
     */
    @Column
    @Size(max = 100)
    public String middle_name;

    /**
     * Должность сотрудника
     */
    @Column(nullable = false)
    @Size(max = 100)
    public String post;

    /**
     * Телефон сотрудника
     */
    @Column
    @Size(max = 20)
    public String phone;

    /**
     * Поле для связи с офисом
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "office_id")
    public Office office;

    /**
     * Поле для связи со справочником документов
     */
    @ManyToOne
    @JoinColumn(name = "citizenship_code")
    public CountryDictionary countryDictionary;

    /**
     * Действующий сотрудник или нет
     */
    public Boolean is_identified;

}
