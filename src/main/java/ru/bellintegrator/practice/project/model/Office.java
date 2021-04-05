package ru.bellintegrator.practice.project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

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
    public Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    public Integer version;

    /**
     * Название офиса
     */
    @Column(nullable = false)
    @Size(max = 100)
    public String name;

    /**
     * Адрес офиса
     */
    @Column(nullable = false)
    @Size(max = 100)
    public String address;

    /**
     * Городской телефон офиса
     */
    @Column
    @Size(max = 20)
    public String phone;

    /**
     * Поле для связи с организациями
     */
    @JsonManagedReference
    @ManyToOne
    public Organization organization;

    /**
     * Актина или нет
     */
    @Column(nullable = true)
    public Boolean isActive;

}

