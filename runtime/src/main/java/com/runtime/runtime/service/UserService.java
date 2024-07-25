package com.runtime.runtime.service;


import com.runtime.runtime.model.User;
import com.runtime.runtime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CRUD

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isPresent()){

            User existingUser = optionalUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setId(user.getId());
            existingUser.setPassword(user.getPassword());
            existingUser.setEnabled(user.isEnabled());

            return userRepository.save(existingUser);

        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }

    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
