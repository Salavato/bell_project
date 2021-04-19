package ru.bellintegrator.practice.project.view;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@ApiModel(description = "общее View для хранения других View")
public class DataView {

    private Object data;
}
