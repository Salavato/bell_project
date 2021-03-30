package ru.bellintegrator.practice.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Calendar;

/**
 * Класс служит для документов
 * @author Salavat
 * @version 1.0
 */

@Entity
@Table(name = "user_document")
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(name = "UserDocument.findById",
        query = "SELECT * FROM user_document WHERE id = ?1",
        resultClass = UserDocument.class)
public class UserDocument {

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
     * Номер документа
     */
    @Column
    @Size(max = 50)
    public String doc_number;

    /**
     * Дата документа
     */
    @Temporal(TemporalType.DATE)
    public Calendar doc_date;

    /**
     * Поле для связи с сотрудниками
     */
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    @JsonManagedReference
    public UserTable userTable;

    /**
     * Поле для связи со справочником документов
     */
    @ManyToOne
    @JoinColumn(name = "doc_code")
    @JsonManagedReference
    public DocDictionary docDictionary;

}
