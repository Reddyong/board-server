package com.fastcampus.boardserver.user.dto;

import com.fastcampus.boardserver.user.entity.User;
import com.fastcampus.boardserver.user.enums.Status;

import java.time.LocalDateTime;

public record UserDTO(
        String userId,
        String password,
        String nickname,
        Boolean isAdmin,
        LocalDateTime createTime,
        LocalDateTime updateTime,
        Boolean isWithDraw,
        Status status
) {
    public static UserDTO of(String userId, String password, String nickname,
                             Boolean isAdmin, LocalDateTime createTime, LocalDateTime updateTime,
                             Boolean isWithDraw, Status status) {
        return new UserDTO(userId, password, nickname, isAdmin, createTime, updateTime, isWithDraw, status);
    }

    public static UserDTO from(User user) {
        return UserDTO.of(
                user.getUserId(),
                user.getPassword(),
                user.getNickname(),
                user.getIsAdmin(),
                user.getCreateTime(),
                user.getUpdateTime(),
                user.getIsWithDraw(),
                user.getStatus()
        );
    }
}
