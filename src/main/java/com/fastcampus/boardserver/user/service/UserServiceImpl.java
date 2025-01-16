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
