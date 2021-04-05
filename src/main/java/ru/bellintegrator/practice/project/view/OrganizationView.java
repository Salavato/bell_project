package ru.bellintegrator.practice.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@ApiModel(description = "Организация")
public class OrganizationView {

    @ApiModelProperty(value = "Полное наименование компании", example = "ООО Промимпорт")
    private String fullName;

    @ApiModelProperty(value = "Сокращенное наименование компании", example = "Промимпорт")
    private String name;

    @ApiModelProperty(value = "ИНН компании", example = "7705902106")
    private String inn;

    @ApiModelProperty(value = "КПП компании", example = "770501001")
    private String kpp;

    @ApiModelProperty(value = "Адресс компании", example = "г. Москва, набережная Овчинниковская, д. 20")
    private String address;

    @ApiModelProperty(value = "Телефон компании", example = "254-11-77")
    private String phone;

    @ApiModelProperty(value = "Ведет компания деятельность или нет", example = "true")
    private Boolean isActive = true;


}
