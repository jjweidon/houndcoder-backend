package com.houndcoder.members.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Tier {
    IRON1("IRON I"),
    IRON2("IRON II"),
    IRON3("IRON III"),
    IRON4("IRON IV"),
    IRON5("IRON V"),
    SILVER1("SILVER I"),
    SILVER2("SILVER II"),
    SILVER3("SILVER III"),
    SILVER4("SILVER IV"),
    SILVER5("SILVER V"),
    GOLD1("GOLD I"),
    GOLD2("GOLD II"),
    GOLD3("GOLD III"),
    GOLD4("GOLD IV"),
    GOLD5("GOLD V"),
    PLATINUM1("PLATINUM I"),
    PLATINUM2("PLATINUM II"),
    PLATINUM3("PLATINUM III"),
    PLATINUM4("PLATINUM IV"),
    PLATINUM5("PLATINUM V"),
    DIAMOND1("DIAMOND I"),
    DIAMOND2("DIAMOND II"),
    DIAMOND3("DIAMOND III"),
    DIAMOND4("DIAMOND IV"),
    DIAMOND5("DIAMOND V"),
    RUBY1("RUBY I"),
    RUBY2("RUBY II"),
    RUBY3("RUBY III"),
    RUBY4("RUBY IV"),
    RUBY5("RUBY V"),
    MASTER("MASTER"),
    CHAMPION("CHAMPION");

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
