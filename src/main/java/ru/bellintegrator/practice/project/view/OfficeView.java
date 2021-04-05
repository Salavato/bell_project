package ru.bellintegrator.practice.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@ApiModel(description = "Офис")
public class OfficeView {

    @ApiModelProperty(value = "Поле для идентификатора офиса", example = "1")
    public Integer orgId;

    @ApiModelProperty(value = "Название офиса", example = "Офис 1")
    public String name;

    @ApiModelProperty(value = "Адрес офиса", example = "г. Калининград, ул. Цюрупа, 10")
    public String address;

    @ApiModelProperty(value = "Аквтиность офиса", example = "true")
    public Boolean isActive = true;

}
