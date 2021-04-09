package ru.bellintegrator.practice.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ApiModel(description = "View для сохраненния офиса")
public class SaveOfficeView {

    @ApiModelProperty(value = "Поле для идентификатора офиса", example = "1")
    @NotNull(message = "orgId cannot be null")
    public Integer orgId;

    @ApiModelProperty(value = "Название офиса", example = "Офис 1")
    public String name;

    @ApiModelProperty(value = "Адрес офиса", example = "г. Калининград, ул. Цюрупа, 10")
    public String address;

    @ApiModelProperty(value = "Номер телефона офиса", example = "755-35-41")
    public String phone;

    @ApiModelProperty(value = "Аквтиность офиса", example = "true")
    public Boolean isActive = true;
}
