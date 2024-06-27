package com.houndcoder.members.exception;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException() {
        super("Profile을 찾을 수 없습니다.");
    }
}
