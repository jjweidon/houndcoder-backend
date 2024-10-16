package com.houndcoder.members.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("관리자"),
    USER("사용자"),
    TEMP("임시 사용자"),
    BANNED("사용정지");

    private final String value;

    public String getRoleName() {
        return "ROLE_" + this.name();
    }
}