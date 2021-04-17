package ru.bellintegrator.practice.project.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.project.model.User;
import ru.bellintegrator.practice.project.service.user.UserServiceImpl;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.office.GetListOfficeView;
import ru.bellintegrator.practice.project.view.organization.GetOrganizationView;
import ru.bellintegrator.practice.project.view.user.*;

import java.util.List;


@RestController
@Api(value = "UserController", description = "Управление информацией о пользователях")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/{id}")
    @ApiOperation(value = "Получить сотрудника по идентификатору", httpMethod = "GET")
    public DataView userGet(@PathVariable(name = "id") Integer id) {
        return userService.findUser(id);
    }

    @ApiOperation(value = "Добавить нового сотрудника", httpMethod = "POST")
    @PostMapping("api/user/save")
    public ResultView organizationPost(@RequestBody SaveUserView user) {
        userService.saveUser(user);
        return new ResultView();
    }

    @ApiOperation(value = "Обновить сотрудника", httpMethod = "POST")
    @PostMapping("api/user/update")
    public ResultView userUpdate(@RequestBody UpdateUserView view) {
        userService.update(view);
        return new ResultView();
    }

    @ApiOperation(value = "Поиск сотрудника по фильтру", httpMethod = "POST")
    @PostMapping("api/user/list")
    public DataView officeFind(@RequestBody FindUserView findUserView) {
        return userService.findBy(findUserView);
    }

}
