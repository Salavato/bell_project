package ru.bellintegrator.practice.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


/**
 * Класс служит для хранения организации
 *
 * @author Salavat
 * @version 1.0
 */

@Entity
@Table(name = "organization")
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(name = "Organization.findById",
        query = "SELECT * FROM Organization WHERE id = ?1",
        resultClass = Organization.class)
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Column(nullable = false)
    @Version
    private Integer version;

    /**
     * Полное имя компании
     */
    @Column(nullable = false)
    @Size(max = 100)
    private String fullName;

    /**
     * Сокращенное имя компании
     */
    @Column(nullable = false)
    @Size(max = 50)
    private String name;

    /**
     * Инн компании
     */
    @Column(nullable = false)
    @Size(max = 50)
    private String inn;

    /**
     * Кпп компании
     */
    @Column(nullable = false)
    @Size(max = 10)
    private String kpp;

    /**
     * Адрес организации
     */
    @Column(name = "address", nullable = false)
    @Size(max = 100)
    private String address;

    /**
     * Городской телефон компании
     */
    @Column
    @Size(max = 20)
    private String phone;


    /**
     * Поле для понимания ведет компания деятельность или нет
     */
    @Column
    private Boolean is_active;

    /**
     * Поле для связи с Офисами
     */
    @JsonBackReference
    @OneToMany(mappedBy = "organization")
    private List<Office> offices = new ArrayList<>();

}
