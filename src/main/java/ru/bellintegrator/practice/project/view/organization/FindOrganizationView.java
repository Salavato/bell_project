package ru.bellintegrator.practice.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ApiModel(description = "View для поиска организации по фильтру")
public class FindOrganizationView {

    @ApiModelProperty(value = "Сокращенное наименование компании", example = "Промимпорт")
    @NotNull(message = "name cannot be null")
    private String name;

    @ApiModelProperty(value = "ИНН компании", example = "7705902106")
    private String inn;

    @ApiModelProperty(value = "Ведет компания деятельность или нет", example = "true")
    private Boolean isActive = true;
}
