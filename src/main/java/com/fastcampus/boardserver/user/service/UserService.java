package com.fastcampus.boardserver.user.service;

import com.fastcampus.boardserver.user.dto.UserDTO;
import com.fastcampus.boardserver.user.dto.request.LoginProfile;
import com.fastcampus.boardserver.user.dto.request.UserProfile;

public interface UserService {
    // 회원가입
    void register(UserProfile userProfile);

    // 로그인
    UserDTO login(LoginProfile loginProfile);

    // 중복 ID 검증

    // 패스워드 변경

    // 유저 정보 조회

    // 회원 탈퇴
}
