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
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;
    public Integer office_id;
    public Integer version;
    public String first_name;
    public String second_name;
    public String middle_name;
    public String post;
    public String phone;
    public String citizenship_code;
    public Boolean is_identified;




}
