package com.expleo.taskmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expleo.taskmanager.dto.CreateTaskRequestDTO;
import com.expleo.taskmanager.dto.TaskDTO;
import com.expleo.taskmanager.mapper.TaskMapper;
import com.expleo.taskmanager.model.Task;
import com.expleo.taskmanager.service.TaskService;
import com.expleo.taskmanager.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id) {
        
        Task task = taskService.getTask(id);

        if (task != null) {

            return ResponseEntity.ok(taskMapper.toDto(task));
        }
        
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTask(){

        List<Task> tasks = taskService.getAllTasks();

        if(!tasks.isEmpty()){

            return ResponseEntity.ok(tasks.stream().map(taskMapper::toDto).collect(Collectors.toList()));
        }
        
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping
    public TaskDTO createTask(@RequestBody CreateTaskRequestDTO createTask) {
       
        Task task = taskMapper.createTaskToEntity(createTask);
        // System.out.println(task.getUser().getId() + " - Test User ID");
        Task taskSaved = taskService.createTask(task);
        
        return taskMapper.toDto(taskSaved);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable String id, @RequestBody TaskDTO taskDTO) {
    
        Task task = taskMapper.toEntity(taskDTO);
        
        Task taskUpdate = taskService.updateTask(Long.valueOf(id), task);

        if (taskUpdate != null) {
            return ResponseEntity.ok(taskMapper.toDto(taskUpdate));
        }

        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable Long id) {
        
        Task task = taskService.deleteTask(id);

        if (task != null) {
            return ResponseEntity.ok(taskMapper.toDto(task));
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskDTO> patchTaskStatus(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        
        Task task = taskMapper.toEntity(taskDTO);
        Task taskUpdate = taskService.patchTaskStatus(id, task.getStatus());

        if (taskUpdate != null) {
            return ResponseEntity.ok(taskMapper.toDto(taskUpdate));
        }

        return ResponseEntity.notFound().build();
    }

}
