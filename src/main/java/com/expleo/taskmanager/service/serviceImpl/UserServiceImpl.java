package com.expleo.taskmanager.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleo.taskmanager.exception.ServerException;
import com.expleo.taskmanager.exception.UserNotFound;
import com.expleo.taskmanager.model.Task;
import com.expleo.taskmanager.model.User;
import com.expleo.taskmanager.repository.TaskRepository;
import com.expleo.taskmanager.repository.UserRepository;
import com.expleo.taskmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public User createUser(User user) {
    
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
    
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFound(userId));
    }

    @Override
    public List<Task> getUserTask(Long userId){

        return taskRepository.findByUserId(userId);
    }

    @Override
    public User updateUser(Long userId, User user) {
        
        if (userRepository.existsById(userId)) {
            user.setId(userId);
        
            return userRepository.save(user);
        }else{

            throw new UserNotFound(userId);
        }
    }

    @Override
    public User deleteUser(Long userId){
        if (userRepository.existsById(userId) && taskRepository.countTasks(userId) == 0) {
            User user = userRepository.findById(userId).orElse(null);

            userRepository.deleteById(userId);
        
            return user;
        }else{

            throw new RuntimeException();
        }
    }
}
