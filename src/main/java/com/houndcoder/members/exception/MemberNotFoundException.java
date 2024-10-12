package com.houndcoder.members.exception;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {
        super("Member를 찾을 수 없습니다.");
    }

    public MemberNotFoundException(Long memberId) {
        super("Member Id: " + memberId + " 를 찾을 수 없습니다.");
    }

    public MemberNotFoundException(String email) {
        super("Member email: " + email + " 를 찾을 수 없습니다.");
    }
}
