package ru.katacademy.springbootuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.katacademy.springbootuser.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
