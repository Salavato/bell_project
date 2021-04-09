package ru.bellintegrator.practice.project.view.documents;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "View для справочника документов")
public class DocDictionaryView {

    @ApiModelProperty(value = "Идентификатор документа сотрудника", example = "3")
    private Integer code;

    @ApiModelProperty(value = "Наименование документа сотрудника", example = "Военный билет")
    private String name;
}
