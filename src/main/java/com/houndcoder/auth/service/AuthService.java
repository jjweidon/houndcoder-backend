package com.houndcoder.auth.service;

import com.houndcoder.auth.dto.SignupRequest;
import com.houndcoder.global.controller.dto.JoinDto;


import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.repository.MemberRepository;
import com.houndcoder.members.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.houndcoder.members.domain.enums.Role.ADMIN;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;

    private final MemberService memberService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 회원가입 처리
    public void joinProcess(SignupRequest signupRequest) {
        if (memberRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
        memberService.createMember(signupRequest.getEmail(), bCryptPasswordEncoder.encode(signupRequest.getPassword()));
    }
}