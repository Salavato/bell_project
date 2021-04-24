package ru.bellintegrator.practice.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@ApiModel(description = "View для поиска сотрудника по фильтру")
public class FindUserView {

    @ApiModelProperty(value = "Поле для идентификатора офиса", example = "1")
    @NotNull
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

    @ApiModelProperty(value = "Поле для идентификатора справочника документа сотрудника", example = "3")
    public Integer docCode;

    @ApiModelProperty(value = "Поле для идентификатора гражданства", example = "643")
    public Integer citizenshipCode;
}
