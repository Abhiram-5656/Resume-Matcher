package com.resumematcher.api.service;

import org.springframework.stereotype.Service;

import com.resumematcher.api.entity.User;
import com.resumematcher.api.exception.ResourceNotFoundException;
import com.resumematcher.api.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
    }

    public boolean emailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }
}