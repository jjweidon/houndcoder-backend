package com.houndcoder.members.exception;

import com.houndcoder.members.domain.Member;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException() {
        super("프로필을 찾을 수 없습니다.");
    }

    public ProfileNotFoundException(Member member) {
        super("Member: " + member.getId() + "의 프로필을 찾을 수 없습니다.");
    }
}
