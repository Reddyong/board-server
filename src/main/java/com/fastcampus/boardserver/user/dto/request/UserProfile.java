package com.fastcampus.boardserver.user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserProfile(
        @NotBlank
        String userId,
        @NotBlank
        String password,
        @NotBlank
        String nickname
) {
}
