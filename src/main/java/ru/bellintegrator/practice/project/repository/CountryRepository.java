package ru.bellintegrator.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.CountryDictionary;

@Repository
public interface CountryRepository extends JpaRepository<CountryDictionary, Integer> {


}
