package ru.bellintegrator.practice.project.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "office")
@Getter
@Setter
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;
    public Integer organization_id;
    public String version;
    public String name;
    public String adress;
    public String phone;
    private Boolean is_active;

}

