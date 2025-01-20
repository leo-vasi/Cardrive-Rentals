package com.leo.cardriverental.service;


import com.leo.cardriverental.model.User;

import com.leo.cardriverental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser (User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Retrieved users: " + users);
        return users;
    }


    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean deleteUserById(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
    return false;
    }


    public boolean isEmailRegistered(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean changeUserStatus(Long userId, String newStatus) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            try {
                User.Status status = User.Status.valueOf(newStatus.toUpperCase());
                user.setStatus(status);
                userRepository.save(user);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }



}
