package com.fastcampus.boardserver.controller;

import com.fastcampus.boardserver.user.dto.UserDTO;
import com.fastcampus.boardserver.user.dto.request.LoginProfile;
import com.fastcampus.boardserver.user.dto.request.UserProfile;
import com.fastcampus.boardserver.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping(path = "/sign-up")
    public ResponseEntity<?> register(
            @Valid @RequestBody UserProfile userProfile
    ) {
        userService.register(userProfile);

        return ResponseEntity.ok("register success");
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginProfile loginProfile
    ) {
        UserDTO loginedUserDTO = userService.login(loginProfile);

        return ResponseEntity.ok(loginedUserDTO);
    }
}
