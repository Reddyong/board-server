package com.fastcampus.boardserver.user.repository;

import com.fastcampus.boardserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserId(String userId);

    Optional<User> findByUserIdAndAndIsWithDraw(String userId, boolean isWithdraw);
}
