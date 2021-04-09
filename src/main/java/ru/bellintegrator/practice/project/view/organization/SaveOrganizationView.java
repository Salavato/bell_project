package ru.bellintegrator.practice.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ApiModel(description = "View для сохраненния организации")
public class SaveOrganizationView {

    @ApiModelProperty(value = "Сокращенное наименование компании", example = "Промимпорт")
    @NotNull(message = "name cannot be null")
    private String name;

    @ApiModelProperty(value = "Полное наименование компании", example = "ООО Промимпорт")
    @NotNull(message = "fullName cannot be null")
    private String fullName;

    @ApiModelProperty(value = "ИНН компании", example = "7705902106")
    @NotNull(message = "inn cannot be null")
    private String inn;

    @ApiModelProperty(value = "КПП компании", example = "770501001")
    @NotNull(message = "kpp cannot be null")
    private String kpp;

    @ApiModelProperty(value = "Адресс компании", example = "г. Москва, набережная Овчинниковская, д. 20")
    @NotNull(message = "address cannot be null")
    private String address;

    @ApiModelProperty(value = "Телефон компании", example = "254-11-77")
    private String phone;

    @ApiModelProperty(value = "Ведет компания деятельность или нет", example = "true")
    private Boolean isActive = true;
}
