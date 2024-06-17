package com.houndcoder.friends.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FriendshipStatus {
    FRIENDS("매우 어려움"),
    BLOCKED("어려움"),
    NORMAL("보통"),
    EASY("쉬움");

    private final String value;

    @JsonCreator
    public static FriendshipStatus deserializer(String value) {
        for(FriendshipStatus friendshipStatus : FriendshipStatus.values()){
            if(friendshipStatus.getValue().equals(value)) {
                return friendshipStatus;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer(){
        return value;
    }
}
