package ru.bellintegrator.practice.project.controller.office;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.bellintegrator.practice.project.view.office.FindOfficeView;
import ru.bellintegrator.practice.project.view.office.GetOfficeView;
import ru.bellintegrator.practice.project.view.office.SaveOfficeView;

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
    void officeGetSuccessTest() {
        mockMvc.perform(get("/api/office/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Офис_1"));
    }

    @SneakyThrows
    @Test
    void officeGetNotExistFailTest() {
        mockMvc.perform(get("/api/office/11")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Office with id: 11 not found"));
    }

    @SneakyThrows
    @Test
    void officeSaveSuccessTest() {
        SaveOfficeView view = new SaveOfficeView();
        view.setOrgId(1);
        view.setName("office_16");
        view.setAddress("New York");
        view.setPhone("212-555-52");

        mockMvc.perform(post("/api/office/save").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value("success"));
    }

    @SneakyThrows
    @Test
    void officeSaveFailTes() {
        SaveOfficeView view = new SaveOfficeView();
        //  view.setOrgId(1);
        view.setName("office_16");
        view.setAddress("New York");
        view.setPhone("212-555-52");

        mockMvc.perform(post("/api/office/save").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("orgId cannot be null; "));
    }

    @SneakyThrows
    @Test
    void officeUpdateSuccessTest() {
        GetOfficeView view = new GetOfficeView();
        view.setId(1);
        view.setName("office_14");
        view.setAddress("London");
        view.setPhone("474-555-52");

        mockMvc.perform(post("/api/office/update").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value("success"));
    }

    @SneakyThrows
    @Test
    void officeUpdateFailTest() {
        GetOfficeView view = new GetOfficeView();
        view.setId(22);
        view.setName("office_14");
        view.setAddress("London");
        view.setPhone("474-555-52");

        mockMvc.perform(post("/api/office/update").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Office with id: 22 not found"));
    }

    @SneakyThrows
    @Test
    void officeFindFilterSuccessTest() {
        FindOfficeView view = new FindOfficeView();
        view.setOrgId(2);
        view.setName("Офис_2");

        mockMvc.perform(post("/api/office/list").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.[0].name").value("Офис_2"));
    }

    @SneakyThrows
    @Test
    void officeFindFilterFailTest() {
        FindOfficeView view = new FindOfficeView();
        view.setOrgId(2);
        view.setName("Офис_102");

        mockMvc.perform(post("/api/office/list").content(asJsonString(view))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"data\":[]}"));


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