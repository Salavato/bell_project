package ru.bellintegrator.practice.project.controller.organization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.bellintegrator.practice.project.repository.OrganizationRepository;
import ru.bellintegrator.practice.project.view.organization.FindOrganizationView;
import ru.bellintegrator.practice.project.view.organization.GetOrganizationView;
import ru.bellintegrator.practice.project.view.organization.SaveOrganizationView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrganizationControllerTest {


    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    MockMvc mockMvc;

    @SneakyThrows
    @Test
    void orgGet() {
        mockMvc.perform(get("/api/organization/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Ромашка"));
    }

    @SneakyThrows
    @Test
    void organizationPost() {
        SaveOrganizationView view = new SaveOrganizationView();
        view.setName("Компания");
        view.setFullName("Полная компания");
        view.setInn("1545451");
        view.setKpp("51515144");
        view.setAddress("Москва, Петровка, 10");

        mockMvc.perform(post("/api/organization/save").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @SneakyThrows
    @Test
    void organizationUpdate() {
        GetOrganizationView view = new GetOrganizationView();
        view.setId(2);
        view.setName("Компания Обнов");
        view.setFullName("Полная обновленная компания");
        view.setInn("154333451");
        view.setKpp("222333443");
        view.setAddress("Москва, Оружейный, 41");

        mockMvc.perform(post("/api/organization/update").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @SneakyThrows
    @Test
    void organizationFindList() {
        FindOrganizationView view = new FindOrganizationView();
        view.setName("Ромашка");

        mockMvc.perform(post("/api/organization/list").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].name").value("Ромашка"));
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