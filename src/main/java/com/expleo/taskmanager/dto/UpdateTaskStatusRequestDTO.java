package com.expleo.taskmanager.dto;

import com.expleo.taskmanager.enums.TaskStatus;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateTaskStatusRequestDTO {
    
    private TaskStatus status;

}
