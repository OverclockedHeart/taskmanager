package com.expleo.taskmanager.repository;

import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.expleo.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT CURRENT_TIMESTAMP", nativeQuery = true)
    Instant getCurrentDbTime();

}
