package com.houndcoder.members.dto;

import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class BasicProfileDto {
    private String nickname;
    private String emil;
    private String introduction;
}
