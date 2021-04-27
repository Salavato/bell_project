package ru.bellintegrator.practice.project.view;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "общее View для вывода результата")
public class ResultView {

    private String result = "success";
}
