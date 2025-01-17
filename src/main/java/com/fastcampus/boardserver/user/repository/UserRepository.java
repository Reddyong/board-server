package com.fastcampus.boardserver.user.repository;

import com.fastcampus.boardserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserId(String userId);
}
