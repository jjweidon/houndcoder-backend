package com.houndcoder.global.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Response<T> {
    private String code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>("SUCCESS", "Request was successful", data);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>("ERROR", message, null);
    }
}
