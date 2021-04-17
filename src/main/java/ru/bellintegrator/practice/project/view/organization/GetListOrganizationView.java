package ru.bellintegrator.practice.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "View Организации с фильтрацией по заданным критериям")
public class GetListOrganizationView {

    @ApiModelProperty(value = "Идентификатор", example = "1")
    private Integer id;

    @ApiModelProperty(value = "Сокращенное наименование компании", example = "Промимпорт")
    private String name;

    @ApiModelProperty(value = "Ведет компания деятельность или нет", example = "true")
    private Boolean isActive = true;
}
