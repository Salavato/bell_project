package ru.bellintegrator.practice.project.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel(description = "общее View для вывода результата")
public class ResultView {

    @JsonProperty("result")
    String result = "success";
}
