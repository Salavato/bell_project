package ru.bellintegrator.practice.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@NoArgsConstructor
@ApiModel(description = "View Сотрудников с фильтрацией по заданным критериям")
public class GetListUserView {

    @ApiModelProperty(value = "Идентификатора сотрудника", example = "1")
    public Integer id;

    @ApiModelProperty(value = "Поле имени сотрудника", example = "Андрей")
    @Column(nullable = false)
    @Size(max = 100)
    public String firstName;

    @ApiModelProperty(value = "Поле фамилии сотрудника", example = "Андреев")
    @Size(max = 100)
    public String secondName;

    @ApiModelProperty(value = "Поле отчества сотрудника", example = "Андреевич")
    @Size(max = 100)
    public String middleName;

    @ApiModelProperty(value = "Поле для должности", example = "Директор")
    @Column(nullable = false)
    @Size(max = 100)
    public String position;

}
