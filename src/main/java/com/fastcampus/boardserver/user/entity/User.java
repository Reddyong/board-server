package com.fastcampus.boardserver.user.entity;

import com.fastcampus.boardserver.user.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Column(name = "is_admin", nullable = false, columnDefinition = "tinyint")
    private Boolean isAdmin;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "is_withdraw", columnDefinition = "tinyint")
    private Boolean isWithDraw;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "varchar(50)")
    private Status status;

}
