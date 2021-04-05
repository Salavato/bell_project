package ru.bellintegrator.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.project.model.User;

public interface UserReposutory extends JpaRepository<User,Integer> {
}
