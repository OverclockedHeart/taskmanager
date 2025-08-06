package com.expleo.taskmanager.service.serviceImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleo.taskmanager.enums.TaskStatus;
import com.expleo.taskmanager.model.Task;
import com.expleo.taskmanager.repository.TaskRepository;
// import com.expleo.taskmanager.repository.TimeRepository;
import com.expleo.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    TaskRepository taskRepository;

    // @Autowired
    // TimeRepository timeRepository;

    @Override
    public Task createTask(Task task) {
     
        if(task.getStatus() == null) {
            task.setStatus(TaskStatus.TODO);
            
        }

        Instant i = taskRepository.getCurrentDbTime();
        LocalDateTime t = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
        
        task.setCreatedAt(t);

        // task.setUpdatedAt(timeRepository.getCurrentTime());

        return taskRepository.save(task);

    }

    @Override
    public Task getTask(Long taskId) {
     
        return taskRepository.findById(taskId).orElse(null);
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

        return null;
    }

    @Override
    public Task deleteTask(Long taskId) {
        
        if(taskRepository.existsById(taskId)) {
            Task task = taskRepository.findById(taskId).orElse(null);
        
            taskRepository.deleteById(taskId);
            
            return task;
        }

        return null;
    }

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }
}
