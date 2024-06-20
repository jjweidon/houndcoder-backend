package com.houndcoder.members.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Position {
    BE("백엔드 엔지니어"),
    FE("프론트엔드 엔지니어"),
    DBA("데이터베이스 관리자"),
    DEVOPS("데브옵스"),
    FULLSTACK("풀스택 엔지니어"),
    DESIGNER("디자이너"),
    PM("프로젝트 매니저");

    private final String value;

    @JsonCreator
    public static Position deserializer(String value) {
        for(Position position : Position.values()){
            if(position.getValue().equals(value)) {
                return position;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer(){
        return value;
    }
}
