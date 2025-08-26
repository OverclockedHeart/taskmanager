package com.expleo.taskmanager.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.expleo.taskmanager.dto.CreateUserRequestDTO;
import com.expleo.taskmanager.dto.UserDTO;
import com.expleo.taskmanager.model.Task;
import com.expleo.taskmanager.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    //DTO -> Entity
    User toEntity(UserDTO UserDTO);
    User createUserToEntity(CreateUserRequestDTO userDTO);

    //Entity -> DTO
    UserDTO toDto(User user);
    CreateUserRequestDTO createUserToDTO(User user);

}
