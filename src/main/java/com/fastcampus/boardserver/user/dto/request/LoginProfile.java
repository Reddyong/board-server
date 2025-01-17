package com.fastcampus.boardserver.user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginProfile(
        @NotBlank String userId,
        @NotBlank String password
) {
}
