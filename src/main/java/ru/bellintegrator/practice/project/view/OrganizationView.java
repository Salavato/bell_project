package ru.bellintegrator.practice.project.view;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationView {

    /**
     * Полное имя компании
     */
    private String fullName;

    /**
     * Сокращенное имя компании
     */
    private String name;

    /**
     * Инн компании
     */
    private String inn;

    /**
     * Кпп компании
     */
    private String kpp;

    /**
     * Адрес организации
     */
    private String address;

    /**
     * Городской телефон компании
     */
    private String phone;


    /**
     * Поле для понимания ведет компания деятельность или нет
     */
    private Boolean is_active;





}
