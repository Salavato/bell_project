package ru.bellintegrator.practice.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@NamedNativeQuery(name = "UserTable.findById",
        query = "SELECT * FROM user_table WHERE id = ?1",
        resultClass = User.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    /**
     * Служебное поле hibernate
     */
    @NotNull
    @Version
    private Integer version;

    /**
     * Имя сотрудника
     */
    @Column(name = "first_name", nullable = false)
    @Size(max = 100)
    private String firstName;

    /**
     * Фамилия сотрудника
     */
    @Column(name = "second_name")
    @Size(max = 100)
    private String secondName;

    /**
     * Отчество сотрудника
     */
    @Size(max = 100)
    @Column(name = "middle_name")
    private String middleName;

    /**
     * Должность сотрудника
     */
    @Column(nullable = false)
    @Size(max = 100)
    private String position;

    /**
     * Телефон сотрудника
     */
    @Column
    @Size(max = 20)
    private String phone;

    /**
     * Поле для связи с офисом
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Поле для связи со справочником документов
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "id")
    private UserDocument userDocument;

    /**
     * Поле для связи со справочником гражданств
     */
    @ManyToOne
    @JoinColumn(name = "citizenship_code")
    private CountryDictionary countryDictionary;

    /**
     * Действующий сотрудник или нет
     */
    @Column(name = "is_identified", nullable = true)
    private Boolean isIdentified;
}
