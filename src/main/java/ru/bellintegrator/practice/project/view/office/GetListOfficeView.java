package ru.bellintegrator.practice.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "View Офиса с фильтрацией по заданным критериям")
public class GetListOfficeView {

    @ApiModelProperty(value = "Поле для идентификатора офиса", example = "1")
    public Integer id;

    @ApiModelProperty(value = "Название офиса", example = "Офис 1")
    public String name;

    @ApiModelProperty(value = "Аквтиность офиса", example = "true")
    public Boolean isActive = true;

}
