package com.houndcoder.games.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
    EASY("쉬움", "1분 ~ 2분", "5줄", 5),
    NORMAL("보통", "3분 ~ 7분", "15줄", 20),
    HARD("어려움", "10분 ~ 15분", "50줄", 90),
    VERY_HARD("매우 어려움", "15분 ~ 30분", "100줄", 200);


    private final String value;
    private final String time;
    private final String lines;
    private final int defaultScore;

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
