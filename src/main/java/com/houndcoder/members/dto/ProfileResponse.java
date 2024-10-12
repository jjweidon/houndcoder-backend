package com.houndcoder.members.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.houndcoder.global.dto.ResponseDto;
import com.houndcoder.members.domain.Profile;
import lombok.*;

@Getter
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProfileResponse implements ResponseDto {
    private String nickname;
    private String email;
    private String bio;

    public static ProfileResponse createWith(final Profile profile) {
        return ProfileResponse.builder()
                .nickname(profile.getNickname())
                .email(profile.getMember().getEmail())
                .bio(profile.getBio())
                .build();
    }
}
