package com.fastcampus.boardserver.user.dto;

import com.fastcampus.boardserver.user.enums.Status;

import java.time.LocalDateTime;

public record UserDTO(
        Integer id,
        String userId,
        String password,
        String nickname,
        Boolean isAdmin,
        LocalDateTime createTime,
        LocalDateTime updateTime,
        Boolean isWithDraw,
        Status status
) {

}
