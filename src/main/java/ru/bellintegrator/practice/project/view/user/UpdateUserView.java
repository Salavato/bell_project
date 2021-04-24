package ru.bellintegrator.practice.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@NoArgsConstructor
@ApiModel(description = "View для обновления сотрудника")
public class UpdateUserView {

    @ApiModelProperty(value = "Идентификатора сотрудника", example = "1")
    public Integer id;

    @ApiModelProperty(value = "Поле для идентификатора офиса", example = "1")
    public Integer officeId;

    @ApiModelProperty(value = "Поле имени сотрудника", example = "Андрей")
    @NotNull(message = "firstName field is null")
    @Size(max = 100)
    public String firstName;

    @ApiModelProperty(value = "Поле фамилии сотрудника", example = "Андреев")
    @Size(max = 100)
    public String secondName;

    @ApiModelProperty(value = "Поле отчества сотрудника", example = "Андреевич")
    @Size(max = 100)
    public String middleName;

    @ApiModelProperty(value = "Поле для должности", example = "Директор")
    @NotNull(message = "position field is null")
    @Size(max = 100)
    public String position;

    @ApiModelProperty(value = "Телефон сотрудника", example = "150-45")
    @Size(max = 100)
    public String phone;

    @ApiModelProperty(value = "Поле для идентификатора справочника документа сотрудника", example = "3")
    public Integer docCode;

    @ApiModelProperty(value = "Название документа сотрудника", example = "Военный билет")
    public String docName;

    @ApiModelProperty(value = "Номер документа сотрудника", example = "4п1-У26")
    public String docNumber;

    @ApiModelProperty(value = "Дата документа сотрудника", example = "2008/04/06")
    public Calendar docDate;

    @ApiModelProperty(value = "Поле для идентификатора гражданства", example = "643")
    public Integer citizenshipCode;

    @ApiModelProperty(value = "Поле которое показывает работает сотрудник или нет", example = "true")
    public Boolean isIdentified = true;
}
