package com.expleo.taskmanager.service;

import java.util.List;

import com.expleo.taskmanager.model.Task;
import com.expleo.taskmanager.model.User;

public interface UserService {    
    User createUser(User user);
    User getUser(Long userId);
    User updateUser(Long userId, User user);    
    User deleteUser(Long userId) ;
    List<Task> getUserTask(Long userId);

}
