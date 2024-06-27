package com.houndcoder.members.dto;

import com.houndcoder.global.ResponseDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ProfileDto {

    @Builder
    @AllArgsConstructor
    public static class Info {
        private String nickname;
        private String emil;
        private String introduction;
    }

    @Setter
    public static class Request {
        private String nickname;
        private String introduction;
    }

    @AllArgsConstructor
    public static class GetResponse implements ResponseDto {
        private Info data;
    }

    @AllArgsConstructor
    public static class PutResponse implements ResponseDto {
        private Long memberId;
    }
}
