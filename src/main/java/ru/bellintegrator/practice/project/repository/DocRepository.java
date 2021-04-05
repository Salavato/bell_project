package ru.bellintegrator.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.project.model.DocDictionary;

@Repository
public interface DocRepository extends JpaRepository<DocDictionary, Integer> {

    DocDictionary findDocDictionaryByCode(Integer code);

}
