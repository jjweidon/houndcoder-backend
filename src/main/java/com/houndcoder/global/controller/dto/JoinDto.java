package com.houndcoder.global.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinDto {
    private String email;
    private String username;
    private String password;
}