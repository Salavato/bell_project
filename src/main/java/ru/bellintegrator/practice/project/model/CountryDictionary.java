package ru.bellintegrator.practice.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country_dictionary")
@Getter
@Setter
@NoArgsConstructor
public class CountryDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer code;
    private String name;
}
