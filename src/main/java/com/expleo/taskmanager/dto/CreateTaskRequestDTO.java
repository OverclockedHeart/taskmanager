package com.expleo.taskmanager.dto;

import java.time.LocalDate;

import com.expleo.taskmanager.enums.TaskPriority;

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

}
