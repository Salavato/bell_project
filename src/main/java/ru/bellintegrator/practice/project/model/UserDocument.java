package ru.bellintegrator.practice.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_document")
@Getter
@Setter
@NoArgsConstructor
public class UserDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;
    public Integer version;
    public String doc_number;
    public String doc_code;
    public String doc_date;


}
