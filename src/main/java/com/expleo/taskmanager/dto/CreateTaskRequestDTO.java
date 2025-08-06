package com.expleo.taskmanager.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.expleo.taskmanager.enums.TaskPriority;
import com.expleo.taskmanager.enums.TaskStatus;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTaskRequestDTO {
    
    private String title;
    private String description;
    private TaskPriority priority; 
    private LocalDate dueDate;
    private Long userId;
    private TaskStatus status;
    private LocalDateTime createdAt;

}
