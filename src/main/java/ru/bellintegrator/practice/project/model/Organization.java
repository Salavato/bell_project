package ru.bellintegrator.practice.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "organization")
@Getter
@Setter
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer version;
    private String name;
    private String  inn;
    private String kpp;
    @Column(name = "address")
    private String address;
    private String phone;
    private Boolean is_active;


}
