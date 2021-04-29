package ru.bellintegrator.practice.project.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.bellintegrator.practice.project.view.user.FindUserView;
import ru.bellintegrator.practice.project.view.user.SaveUserView;
import ru.bellintegrator.practice.project.view.user.UpdateUserView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @SneakyThrows
    @Test
    void userGetSuccessTest() {
        mockMvc.perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Иван"));
    }

    @SneakyThrows
    @Test
    void userGetNotExistFailTest() {
        mockMvc.perform(get("/api/user/11")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User with id: 11 not found"));
    }

    @Test
    @SneakyThrows
    void userSaveSuccessTest() {
        SaveUserView view = new SaveUserView();
        view.setOfficeId(1);
        view.setFirstName("Новое имя сотрудника");
        view.setDocCode(7);
        view.setCitizenshipCode(643);
        view.setPosition("Дворник");

        mockMvc.perform(post("/api/user/save").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    @SneakyThrows
    void userSaveFailTes() {
        SaveUserView view = new SaveUserView();
        //   view.setOfficeId(1);
        view.setFirstName("Новое имя сотрудника");
        view.setDocCode(7);
        view.setCitizenshipCode(643);
        view.setPosition("Дворник");

        mockMvc.perform(post("/api/user/save").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Sorry internal error"));
    }

    @SneakyThrows
    @Test
    void userUpdateSuccessTest() {
        UpdateUserView view = new UpdateUserView();
        view.setId(1);
        view.setOfficeId(2);
        view.setFirstName("Иван");
        view.setCitizenshipCode(201);
        view.setDocCode(7);
        view.setPosition("Дворник");

        mockMvc.perform(post("/api/user/update").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value("success"));
    }

    @SneakyThrows
    @Test
    void userUpdateFailTes() {
        UpdateUserView view = new UpdateUserView();
        view.setId(1);
        //  view.setOfficeId(2);
        view.setFirstName("Иван");
        view.setCitizenshipCode(201);
        view.setDocCode(7);
        view.setPosition("Дворник");

        mockMvc.perform(post("/api/user/update").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Sorry internal error"));
    }

    @SneakyThrows
    @Test
    void officeFindFilterSuccessTest() {
        FindUserView view = new FindUserView();
        view.setOfficeId(2);
        view.setFirstName("Bob");
        view.setPosition("Менеджер");

        mockMvc.perform(post("/api/user/list").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].firstName").value("Bob"));
    }

    @SneakyThrows
    @Test
    void officeFindFilterFailTest() {
        FindUserView view = new FindUserView();
        view.setOfficeId(1);
        view.setFirstName("Петрушка");
        view.setPosition("менеджер");

        mockMvc.perform(post("/api/user/list").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}