package com.expleo.taskmanager.service;

import com.expleo.taskmanager.enums.TaskStatus;
import com.expleo.taskmanager.model.Task;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTask(Long taskId);
    Task getUserId(Long userId);
    Task updateTask(Long taskId, Task task);
    Task deleteTask(Long taskId);
    Task patchTaskStatus(Long taskId, TaskStatus status);
    
    List<Task> getAllTasks();

}
