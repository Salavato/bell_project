package ru.bellintegrator.practice.project.view.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "View для возврата Exception")
public class ViewException {

    @ApiModelProperty(value = "Сообщение", example = "Error")
    private String message;

    private String exceptionCode;
}
