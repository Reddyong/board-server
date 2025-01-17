package com.fastcampus.boardserver.user.service;

import com.fastcampus.boardserver.user.dto.UserDTO;
import com.fastcampus.boardserver.user.dto.request.UserProfile;
import com.fastcampus.boardserver.user.entity.User;
import com.fastcampus.boardserver.user.enums.Status;
import com.fastcampus.boardserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserProfile userProfile) {
        // 중복 아이디 검증
        if (userRepository.existsByUserId(userProfile.userId())) {
            throw new IllegalArgumentException("이미 사용중인 아이디 입니다.");
        }

        // 비밀번호 인코딩
        String encodedPassword = passwordEncoder.encode(userProfile.password());

        User user = User.of(
                userProfile.userId(),
                encodedPassword,
                userProfile.nickname(),
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                false,
                Status.DEFAULT
        );

        userRepository.save(user);
    }
}
