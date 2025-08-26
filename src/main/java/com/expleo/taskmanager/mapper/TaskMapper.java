package com.expleo.taskmanager.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.expleo.taskmanager.dto.CreateTaskRequestDTO;
import com.expleo.taskmanager.dto.TaskDTO;
import com.expleo.taskmanager.dto.UpdateTaskStatusRequestDTO;
import com.expleo.taskmanager.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    //DTO -> Entity
    @Mapping(target = "user.id", source = "userId")
    Task toEntity(TaskDTO taskDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", source = "userId")
    Task createTaskToEntity(CreateTaskRequestDTO createTaskRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", source = "userId")
    Task updateTaskToEntity(UpdateTaskStatusRequestDTO updateTaskRequestDTO);

    // Task patchTaskToEntity


    //Enitty -> DTO
    @Mapping(target = "userId", source = "task.user.id")
    TaskDTO toDto(Task task);

    @Mapping(target = "userId", source = "task.user.id")
    CreateTaskRequestDTO createTaskToDTO(Task task);

    UpdateTaskStatusRequestDTO updateTaskToDTO(Task task);

}