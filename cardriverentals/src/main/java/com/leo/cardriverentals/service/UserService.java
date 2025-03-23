package com.leo.cardriverentals.service;

import com.leo.cardriverentals.dto.UserDTO;
import com.leo.cardriverentals.model.User;
import com.leo.cardriverentals.repository.UserRepository;
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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<UserDTO> getAllUserDetails() {
        return userRepository.findAllUserDetails();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        existingUser.setName(user.getName());
        existingUser.setGender(user.getGender());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setCpf(user.getCpf());
        existingUser.setPassword(user.getPassword());
        existingUser.setUserProfilePicture(user.getUserProfilePicture());
        existingUser.setStatus(user.getStatus());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
