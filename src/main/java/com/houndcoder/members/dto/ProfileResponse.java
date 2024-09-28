package com.houndcoder.members.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.houndcoder.global.dto.ResponseDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProfileResponse implements ResponseDto {
    private String nickname;
    private String email;
    private String introduction;

    public static ProfileResponse createWith(final BasicProfileDto basicProfileDto) {
        return ProfileResponse.builder()
                .nickname(basicProfileDto.getNickname())
                .email(basicProfileDto.getEmil())
                .introduction(basicProfileDto.getIntroduction())
                .build();
    }
}
