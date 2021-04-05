package ru.bellintegrator.practice.project.controller.documents;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.model.UserDocument;
import ru.bellintegrator.practice.project.service.documents.UserDocumentServiceImpl;
import ru.bellintegrator.practice.project.view.UserDocumentView;

@RestController
@Api(value = "UserDocumentController", description = "Управление информацией о документах сотрудников")
public class UserDocumentController {

    private final UserDocumentServiceImpl userDocumentService;

    @Autowired
    public UserDocumentController(UserDocumentServiceImpl userDocumentService) {
        this.userDocumentService = userDocumentService;
    }

    @ApiOperation(value = "Получить документ сотрудника по идентификатору", httpMethod = "GET")
    @GetMapping("/api/userdoc/{id}")
    public UserDocument userDocGet(@PathVariable(name = "id") Integer id) {
        return userDocumentService.findUserDocument(id);

    }

    @ApiOperation(value = "Обновить документ сотрудника", httpMethod = "UPDATE")
    @PostMapping("api/userdoc/update")
    public String organizationPost(@RequestBody UserDocumentView view) {
        userDocumentService.updateUserDocument(view);
        return "success";
    }


}
