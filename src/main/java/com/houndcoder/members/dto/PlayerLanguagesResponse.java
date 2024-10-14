package com.houndcoder.members.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.houndcoder.global.dto.ResponseDto;
import com.houndcoder.members.domain.PlayerLanguage;
import lombok.*;

import java.util.List;

@Getter
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlayerLanguagesResponse implements ResponseDto {
    private List<PlayerLanguage> languages;

    public static PlayerLanguagesResponse createWith(final List<PlayerLanguage> playerLanguages) {
        return PlayerLanguagesResponse.builder()
                .languages(playerLanguages)
                .build();
    }
}