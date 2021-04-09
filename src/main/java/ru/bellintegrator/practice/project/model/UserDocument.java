package ru.bellintegrator.practice.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "id")
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Column(nullable = false)
    @Version
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "doc_number")
    @Size(max = 200)
    private String docNumber;

    /**
     * Дата документа
     */
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Calendar docDate;

    /**
     * Поле для связи с сотрудниками
     */
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    /**
     * Поле для связи со справочником документов
     */
    @ManyToOne
    @JoinColumn(name = "doc_code")
    private DocDictionary docDictionary;

}
