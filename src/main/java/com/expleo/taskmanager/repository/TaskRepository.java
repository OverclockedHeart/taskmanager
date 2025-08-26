package com.expleo.taskmanager.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expleo.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT CURRENT_TIMESTAMP", nativeQuery = true)
    Instant getCurrentDbTime();

    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId", nativeQuery = true)
    List<Task> findByUserId (Long userId);

    // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :userId")
    // List<Task> findByUserIdJpa (@Param("userId") Long userId);

    @Query(value = "SELECT COUNT(*) FROM tasks WHERE user_id = :userId", nativeQuery = true)
    Long countTasks (Long userId);

}
