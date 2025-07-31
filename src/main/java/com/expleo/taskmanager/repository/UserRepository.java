package com.expleo.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expleo.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
