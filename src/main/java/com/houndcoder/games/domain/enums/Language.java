package com.houndcoder.games.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    C("c"),
    CPP("c++"),
    CS("c#"),
    PY("python"),
    JAVA("java"),
    JS("javascript"),
    KT("kotlin"),
    SWIFT("swift"),
    GO("go"),
    RB("ruby");

    private final String value;

    @JsonCreator
    public static Language deserializer(String value) {
        for(Language language : Language.values()){
            if(language.getValue().equals(value)) {
                return language;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer(){
        return value;
    }
}
