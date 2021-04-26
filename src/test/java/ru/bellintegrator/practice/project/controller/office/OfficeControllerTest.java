package ru.bellintegrator.practice.project.controller.office;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.office.SaveOfficeView;
import ru.bellintegrator.practice.project.view.organization.SaveOrganizationView;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OfficeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @SneakyThrows
    @Test
    void officeGet() {
        mockMvc.perform(get("/api/office/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Офис_1"));
    }

    @SneakyThrows
    @Test
    void officePost() {
        SaveOfficeView view = new SaveOfficeView();
        view.setOrgId(1);
        view.setName("office_16");
        view.setAddress("New York");
        view.setPhone("212-555-52");

        mockMvc.perform(post("/api/office/save").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
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