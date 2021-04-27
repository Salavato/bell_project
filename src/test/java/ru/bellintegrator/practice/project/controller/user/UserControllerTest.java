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
    void userGet() {
        mockMvc.perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.firstName").value("Иван"));
    }

    @Test
    @SneakyThrows
    void userSave() {
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

    @SneakyThrows
    @Test
    void userUpdate() {
        UpdateUserView view = new UpdateUserView();
        view.setId(1);
        view.setOfficeId(2);
        view.setFirstName("Петрушка");
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
    void officeFind() {
        FindUserView view = new FindUserView();
        view.setOfficeId(1);
        view.setFirstName("Иван");
        view.setPosition("менеджер");

        mockMvc.perform(post("/api/user/list").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].firstName").value("Иван"));
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