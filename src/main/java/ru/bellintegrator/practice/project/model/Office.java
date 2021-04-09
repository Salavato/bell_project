package ru.bellintegrator.practice.project.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Класс служит для хранения офисов
 * @author Salavat
 * @version 1.0
 */

@Entity
@Table(name = "office")
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(name = "Office.findById",
        query = "SELECT * FROM Office WHERE id = ?1",
        resultClass = Office.class)
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Название офиса
     */
    @Column(nullable = false)
    @Size(max = 100)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(nullable = false)
    @Size(max = 100)
    private String address;

    /**
     * Городской телефон офиса
     */
    @Column
    @Size(max = 20)
    private String phone;

    /**
     * Поле для связи с организациями
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    /**
     * Актина или нет
     */
    @Column(nullable = true)
    private Boolean isActive;
}

