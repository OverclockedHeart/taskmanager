package com.expleo.taskmanager.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleo.taskmanager.model.User;
import com.expleo.taskmanager.repository.UserRepository;
import com.expleo.taskmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
      
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
       
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(Long userId, User user) {
        
        if (userRepository.existsById(userId)) {
            user.setId(userId);
        
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public User deleteUser(Long userId) {
        User user = getUser(userId);
       
        if (user != null) {
            userRepository.delete(user);
          
            return user;
        }

        return null;
    }
    
}
