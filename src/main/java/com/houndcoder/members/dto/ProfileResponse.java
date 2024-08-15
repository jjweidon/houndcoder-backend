package com.houndcoder.members.dto;

import com.houndcoder.global.dto.ResponseDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse implements ResponseDto {
    private String nickname;
    private String emil;
    private String introduction;

    public ProfileResponse createWith(final BasicProfileDto basicProfileDto) {
        return ProfileResponse.builder()
                .emil(basicProfileDto.get)
                .build();
    }
}
