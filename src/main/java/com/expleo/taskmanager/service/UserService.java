package com.expleo.taskmanager.service;

import com.expleo.taskmanager.model.User;

public interface UserService {    
    User createUser(User user);
    User getUser(Long userId);
    User updateUser(Long userId, User user);    
    User deleteUser(Long userId);

}
