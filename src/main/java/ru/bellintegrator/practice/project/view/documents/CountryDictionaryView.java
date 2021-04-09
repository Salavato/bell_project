package ru.bellintegrator.practice.project.view.documents;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "View для гражданств сотрудника")
public class CountryDictionaryView {

    @ApiModelProperty(value = "Идентификатор гражданства", example = "643")
    private Integer code;

    @ApiModelProperty(value = "Наименование гражданства", example = "Российская Федерация")
    private String name;
}
