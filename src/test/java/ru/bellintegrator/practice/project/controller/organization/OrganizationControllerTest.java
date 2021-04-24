package ru.bellintegrator.practice.project.controller.organization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.project.model.Organization;
import ru.bellintegrator.practice.project.repository.OrganizationRepository;
import ru.bellintegrator.practice.project.view.DataView;
import ru.bellintegrator.practice.project.view.ResultView;
import ru.bellintegrator.practice.project.view.organization.GetOrganizationView;
import ru.bellintegrator.practice.project.view.organization.SaveOrganizationView;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrganizationControllerTest {

//    @Test
//    void orgGet() {
//        //входные данные
//
//        //вызов тестируемого метода
//
//        //проверка полученных результатов
//        assertEquals(1,1);
//    }

    @Autowired
    OrganizationController organizationController;
    @Autowired
    OrganizationRepository organizationRepository;

    @Test
    void orgGet() {
        //входные данные
        int id = 1;
        String expectedFullName = "ООО Ромашка";

        //вызов тестируемого метода
        DataView rez = organizationController.orgGet(id);

//        GetOrganizationView getOrganizationView = new GetOrganizationView();
//        DataView dataView = new DataView(getOrganizationView);
//        dataView.getData();

        //проверка полученных результатов
        GetOrganizationView actual = (GetOrganizationView) rez.getData();
        assertEquals(expectedFullName, actual.getFullName());
        assertEquals("7718057567", actual.getInn());
    }


    @Test
    void organizationPost() {
        //входные данные
        SaveOrganizationView view = new SaveOrganizationView();
        view.setName("Компания");
        view.setFullName("Полная компания");
        view.setInn("1545451");
        view.setKpp("51515144");
        view.setAddress("Москва, Петровка, 10");

        //вызов тестируемого метода
        organizationController.organizationPost(view);

        //проверка полученных результатов
        Organization actualOrg = organizationRepository.findById(3).get();
        assertEquals(view.getName(), actualOrg.getName());
        assertEquals(view.getFullName(), actualOrg.getFullName());
    }

    @Test
    void organizationUpdate() {
        GetOrganizationView view = new GetOrganizationView();
        view.setId(2);
        view.setName("Компания Обнов");
        view.setFullName("Полная обновленная компания");
        view.setInn("154333451");
        view.setKpp("222333443");
        view.setAddress("Москва, Оружейный, 41");

        //вызов тестируемого метода
        organizationController.organizationUpdate(view);

        //проверка полученных результатов
        Organization actualUpdateOrg = organizationRepository.findById(2).get();
        assertEquals(view.getName(), actualUpdateOrg.getName());
        assertEquals(view.getInn(), view.getInn());

    }
}