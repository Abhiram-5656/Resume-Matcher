package com.resumematcher.api.dto;

import java.time.LocalDateTime;

import com.resumematcher.api.entity.User;

public record UserResponse(
        Long id,
        String fullName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}