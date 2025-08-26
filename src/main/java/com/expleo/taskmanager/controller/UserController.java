package com.expleo.taskmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expleo.taskmanager.dto.CreateUserRequestDTO;
import com.expleo.taskmanager.dto.UserDTO;
import com.expleo.taskmanager.exception.ServerException;
import com.expleo.taskmanager.mapper.UserMapper;
import com.expleo.taskmanager.model.Task;
import com.expleo.taskmanager.model.User;
import com.expleo.taskmanager.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        
        User user = userService.getUser(id);

        if (user != null) {

            return ResponseEntity.ok(userMapper.toDto(user));
        }
        
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable Long id) {

        List<Task> tasks = userService.getUserTask(id);
        
        // System.out.println(userService.getUserTask(id));

        return ResponseEntity.ok(tasks);
    }
    
    
    @PostMapping
    public ResponseEntity<CreateUserRequestDTO> createUser(@RequestBody @Valid CreateUserRequestDTO createUser) {
        
        User user = userMapper.createUserToEntity(createUser);
        User userSaved = userService.createUser(user);

        return ResponseEntity.ok(userMapper.createUserToDTO(userSaved));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> putMethodName(@PathVariable String id, @RequestBody UserDTO userDTO) {
        
        User user = userMapper.toEntity(userDTO);
        User userUpdate = userService.updateUser(Long.valueOf(id), user);

        if (userUpdate != null) {

            return ResponseEntity.ok(userMapper.toDto(userUpdate));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        
        userService.deleteUser(id);

    //     if (user != null) {

    //         return ResponseEntity.ok(userMapper.toDto(user));
    //     }

    //     return ResponseEntity.notFound().build();
    }
}
