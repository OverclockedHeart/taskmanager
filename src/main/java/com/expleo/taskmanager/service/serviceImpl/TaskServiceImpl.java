package com.expleo.taskmanager.service.serviceImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleo.taskmanager.enums.TaskStatus;
import com.expleo.taskmanager.exception.TaskNotFound;
import com.expleo.taskmanager.exception.UserNotFound;
import com.expleo.taskmanager.model.Task;
import com.expleo.taskmanager.model.User;
import com.expleo.taskmanager.repository.TaskRepository;
import com.expleo.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
     
        if(task.getStatus() == null) {
            task.setStatus(TaskStatus.TODO);
            
        }

        Instant i = taskRepository.getCurrentDbTime();
        LocalDateTime t = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
        
        task.setCreatedAt(t);

        return taskRepository.save(task);
    }

    @Override
    public Task getTask(Long taskId) {
     
        return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFound(taskId));
    }

    @Override
    public Task getUserId(Long userId){

        return taskRepository.findById(userId).orElseThrow(() -> new UserNotFound(userId));
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        
        if(taskRepository.existsById(taskId)) {
            task.setId(taskId);
        
            Instant i = taskRepository.getCurrentDbTime();
            LocalDateTime t = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
            
            task.setUpdatedAt(t);

            return taskRepository.save(task);
        }

        throw new TaskNotFound(taskId);    
    }

    @Override
    public Task patchTaskStatus(Long taskId, TaskStatus status) {
        
        Task task = taskRepository.findById(taskId).orElse(null); 

        if (task != null) {
            task.setStatus(status);
            
            Instant i = taskRepository.getCurrentDbTime();
            LocalDateTime t = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
            
            task.setUpdatedAt(t);

            return taskRepository.save(task);
        }
    
        throw new TaskNotFound(taskId);    
    }

    @Override
    public Task deleteTask(Long taskId) {
        
        if(taskRepository.existsById(taskId)) {
            Task task = taskRepository.findById(taskId).orElse(null);
        
            taskRepository.deleteById(taskId);
            
            return task;
        }

        throw new TaskNotFound(taskId);
    }

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }
}
