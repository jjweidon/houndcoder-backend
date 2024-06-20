package com.houndcoder.games.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
    VERY_HARD("매우 어려움"),
    HARD("어려움"),
    NORMAL("보통"),
    EASY("쉬움");

    private final String value;

    @JsonCreator
    public static Difficulty deserializer(String value) {
        for(Difficulty difficulty : Difficulty.values()){
            if(difficulty.getValue().equals(value)) {
                return difficulty;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer(){
        return value;
    }
}
