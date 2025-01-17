package com.fastcampus.boardserver.user.service;

import com.fastcampus.boardserver.user.dto.UserDTO;
import com.fastcampus.boardserver.user.dto.request.LoginProfile;
import com.fastcampus.boardserver.user.dto.request.UserProfile;
import com.fastcampus.boardserver.user.entity.User;
import com.fastcampus.boardserver.user.enums.Status;
import com.fastcampus.boardserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public UserDTO login(LoginProfile loginProfile) {
        if (!userRepository.existsByUserId(loginProfile.userId())) {
            throw new IllegalArgumentException("존재하지 않는 아이디 정보입니다");
        }

        User user = userRepository.findByUserIdAndAndIsWithDraw(loginProfile.userId(), false).get();

        if (!passwordEncoder.matches(loginProfile.password(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        return UserDTO.from(user);
    }


}
