package ru.bellintegrator.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.project.model.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
