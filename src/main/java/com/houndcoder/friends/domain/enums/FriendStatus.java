package com.houndcoder.friends.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FriendStatus {
    REQUESTED("대기"),
    ACCEPTED("수락"),
    REJECTED("거절"),
    HIDDEN("숨김"),
    BLOCKED("차단");

    private final String value;

    @JsonCreator
    public static FriendStatus deserializer(String value) {
        for(FriendStatus friendshipStatus : FriendStatus.values()){
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
