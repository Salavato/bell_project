package ru.bellintegrator.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.project.model.UserDocument;

public interface UserDocRepository extends JpaRepository<UserDocument, Integer> {
}
