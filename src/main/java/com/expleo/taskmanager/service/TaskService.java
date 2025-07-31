package com.expleo.taskmanager.service;

import com.expleo.taskmanager.model.Task;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTask(Long taskId);
    Task updateTask(Long taskId, Task task);
    Task deleteTask(Long taskId);
    
    List<Task> getAllTasks();

}
