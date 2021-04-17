package ru.bellintegrator.practice.project.controller.documents;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.DocDictionary;
import ru.bellintegrator.practice.project.repository.DocRepository;
import ru.bellintegrator.practice.project.service.documents.DocDictionaryService;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.documents.DocDictionaryView;

import java.util.List;

@RestController
@Api(value = "DocDictionaryController", description = "Управление информацией о справочнике документах")
public class DocDictionaryController {

    private final DocDictionaryService docDictionaryService;

    @Autowired
    public DocDictionaryController(DocDictionaryService docDictionaryService) {
        this.docDictionaryService = docDictionaryService;
    }

    @ApiOperation(value = "Получить список справочника", httpMethod = "GET")
    @GetMapping("/api/docs")
    public DataView docListGet() {
        return docDictionaryService.all();
    }

    @ApiOperation(value = "Добавить новый справочник документа", httpMethod = "POST")
    @PostMapping("api/docs/save")
    public ResultView docPost(@RequestBody DocDictionaryView view) {
        docDictionaryService.save(view);
        return new ResultView();
    }
}
