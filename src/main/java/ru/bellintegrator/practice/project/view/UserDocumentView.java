package ru.bellintegrator.practice.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@NoArgsConstructor
@ApiModel(description = "Документы сотрудника")
public class UserDocumentView {

    @ApiModelProperty(value = "Идентификатор сотрудника", example = "1")
    Integer idUser;

    @ApiModelProperty(value = "Номер документа сотрудника", example = "4п1-У26")
    String docNumber;

    @ApiModelProperty(value = "Код документа для связи со справочником документов", example = "1")
    Integer docCode;

    @ApiModelProperty(value = "Дата документа", example = "2010/02/02")
    Calendar docDate;




}
