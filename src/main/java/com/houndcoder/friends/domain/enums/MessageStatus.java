package com.houndcoder.friends.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageStatus {
    UNREAD("안읽음"),
    READ("읽음"),
    REMOVE("삭제"),
    FAVORITE("즐겨찾기"),
    ARCHIVED("보관");

    private final String value;

    @JsonCreator
    public static MessageStatus deserializer(String value) {
        for(MessageStatus messageStatus : MessageStatus.values()){
            if(messageStatus.getValue().equals(value)) {
                return messageStatus;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer(){
        return value;
    }
}
