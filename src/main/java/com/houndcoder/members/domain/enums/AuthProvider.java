package com.houndcoder.members.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthProvider {
    NORMAL("일반"),
    KAKAO("카카오"),
    GOOGLE("구글"),
    GITHUB("깃허브");

    private final String value;

    @JsonCreator
    public static Tier deserializer(String value) {
        for(Tier tier : Tier.values()){
            if(tier.getValue().equals(value)) {
                return tier;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer(){
        return value;
    }
}
