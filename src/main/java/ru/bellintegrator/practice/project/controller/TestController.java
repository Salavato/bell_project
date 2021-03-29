package ru.bellintegrator.practice.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.project.model.*;
import ru.bellintegrator.practice.project.repository.*;

import java.util.GregorianCalendar;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final CountryRepository countryRepository;
    private final DocRepository docRepository;
    private final OrganizationRepository organizationRepository;
    private final UserReposutory userReposutory;
    private final OfficeRepository officeRepository;
    private final UserDocRepository userDocRepository;

    //гражданства
    @GetMapping("/addcountry")
    public void addCountryDict() {

        CountryDictionary countryDictionary = new CountryDictionary();
        countryDictionary.setCode(643);
        countryDictionary.setName("Российская Федерация");

        countryRepository.save(countryDictionary);
    }

    //справочник доков
    @GetMapping("/adddocdict")
    public void addDocDict() {

        DocDictionary docDictionary = new DocDictionary();
        docDictionary.setCode(11);
        docDictionary.setName("Студ билет");

        docRepository.save(docDictionary);
    }

    //документ пользователя
    @GetMapping("/adduserdoc")
    public void addUserDoc() {

        UserTable byId = userReposutory.findById(1).get();

        UserDocument userDocument = new UserDocument();
        userDocument.setUserTable(byId);
        userDocument.setDoc_number("E348$");
        userDocument.setDoc_date(new GregorianCalendar(2008,04,26));

        userDocRepository.save(userDocument);
    }

    @GetMapping("/addorg")
    public void addOrganisation() {
        Organization organization = new Organization();
        organization.setFullName("ООО Промимпорт");
        organization.setName("Промимпорт");
        organization.setInn("4418054567");
        organization.setKpp("441801001");
        organization.setAddress("г. Москва, Оружейный переулок, 41");

        organizationRepository.save(organization);
    }

    @GetMapping("/addoffice")
    public void addOffice() {
        Organization byId = organizationRepository.findById(1).get();

        Office office = new Office();
        office.setName("office 1");
        office.setAddress("London");
        office.setIsActive(true);
        office.setOrganization(byId);

        officeRepository.save(office);
    }


    @GetMapping("/adduser")
    public void addUser() {
        Office officebyId = officeRepository.findById(1).get();

        UserTable user1 = new UserTable();
        user1.setFirst_name("Иван");
        user1.setPost("менеджер");
        user1.setOffice(officebyId);

        userReposutory.save(user1);
    }

}
