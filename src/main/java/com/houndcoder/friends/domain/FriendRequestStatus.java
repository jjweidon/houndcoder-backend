package com.houndcoder.friends.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FriendRequestStatus {
    WAIT("대기"),
    ACCEPT("수락"),
    DENY("거절");

    private final String value;

    @JsonCreator
    public static FriendRequestStatus deserializer(String value) {
        for(FriendRequestStatus friendRequestStatus : FriendRequestStatus.values()){
            if(friendRequestStatus.getValue().equals(value)) {
                return friendRequestStatus;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer(){
        return value;
    }
}
