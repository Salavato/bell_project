package ru.bellintegrator.practice.project.controller.documents;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.service.documents.UserDocumentServiceImpl;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.documents.UserDocumentView;

import java.util.List;

@RestController
@Api(value = "UserDocumentController", description = "Управление информацией о документах сотрудников")
public class UserDocumentController {

    private final UserDocumentServiceImpl userDocumentService;

    @Autowired
    public UserDocumentController(UserDocumentServiceImpl userDocumentService) {
        this.userDocumentService = userDocumentService;
    }

    @ApiOperation(value = "Получить полный список документов сотрудников", httpMethod = "GET")
    @GetMapping("/api/userdoc")
    public List<UserDocumentView> userDocGet() {
        return userDocumentService.allUserDocument();

    }

    @ApiOperation(value = "Обновить документ сотрудника", httpMethod = "POST")
    @PostMapping("api/userdoc/update")
    public ResultView updateUserDoc(@RequestBody UserDocumentView view) {
        userDocumentService.updateUserDocument(view);
        return new ResultView();
    }
}
