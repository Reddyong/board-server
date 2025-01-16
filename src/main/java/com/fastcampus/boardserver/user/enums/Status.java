package com.fastcampus.boardserver.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    DEFAULT(1),
    ADMIN(2),
    DELETED(0)
    ;

    private final int num;
}
