package com.houndcoder.members.service;

import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.Profile;
import com.houndcoder.members.domain.enums.Role;
import com.houndcoder.members.domain.repository.MemberRepository;
import com.houndcoder.members.domain.repository.ProfileRepository;
import com.houndcoder.members.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final ProfileRepository profileRepository;

    // Member 생성
    public void createMember(String email, String encodedPassword) {
        Member newMember = Member.builder()
                .email(email)
                .password(encodedPassword)
                .role(Role.USER) // 역할 설정
                .build();
        memberRepository.save(newMember);

        Profile profile = Profile.builder()
                .nickname("하운드" + newMember.getId())
                .member(newMember)
                .build();
        profileRepository.save(profile);
    }

    public Member findMemberById(final Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
    }

    public Member findMemberByEmail(final String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException(email));
    }
}
