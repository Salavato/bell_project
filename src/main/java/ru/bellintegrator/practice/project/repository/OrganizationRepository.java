package ru.bellintegrator.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.project.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {



}
