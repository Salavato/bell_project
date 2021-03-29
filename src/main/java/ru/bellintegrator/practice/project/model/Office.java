package ru.bellintegrator.practice.project.model;


import com.sun.istack.NotNull;
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
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    /**
     * Служебное поле hibernate
     */
    @Column(nullable = false)
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
     * Поле для связи с сотрудниками
     */
    @OneToMany(mappedBy = "office")
    public List<UserTable> userTableList;

    /**
     * Поле для связи с организациями
     */
    @ManyToOne
    public Organization organization;

    /**
     * Актина или нет
     */
    @NotNull
    public Boolean isActive;







}

