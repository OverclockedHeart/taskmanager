package com.expleo.taskmanager.mapper;

import org.mapstruct.Mapper;

import com.expleo.taskmanager.dto.CreateTaskRequestDTO;
import com.expleo.taskmanager.dto.TaskDTO;
import com.expleo.taskmanager.dto.UpdateTaskStatusRequestDTO;
import com.expleo.taskmanager.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    //DTO -> Entity
    Task toEntity(TaskDTO taskDTO);
    Task createTaskToEntity(CreateTaskRequestDTO taskRequestDTO);
    Task updateTaskToEntity(UpdateTaskStatusRequestDTO updateTasDTO);

    //Enitty -> DTO
    TaskDTO toDto(Task task);
    CreateTaskRequestDTO createTaskToDTO(Task task);
    UpdateTaskStatusRequestDTO updateTaskToDTO(Task task);

}