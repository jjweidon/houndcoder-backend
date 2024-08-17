package com.houndcoder.auth.service;

import com.houndcoder.global.controller.dto.JoinDto;


import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.houndcoder.members.domain.enums.Role.ADMIN;
import static com.houndcoder.members.domain.enums.Role.USER;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void joinProcess(JoinDto joinDTO) {
        // 이메일 중복 확인
        boolean isExistEmail = memberRepository.existsByEmail(joinDTO.getEmail());
        if (isExistEmail) {
            return;
        }

        // 닉네임 중복 확인
        boolean isExistNickname = memberRepository.existByNickname(joinDTO.getUsername());
        if (isExistNickname) {
            return;
        }

        Member data = new Member();

        data.setNickname(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setRole(ADMIN);

        memberRepository.save(data);
    }
}