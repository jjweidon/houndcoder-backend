package com.houndcoder.members.service;

import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.Profile;
import com.houndcoder.members.domain.repository.MemberRepository;
import com.houndcoder.members.domain.repository.ProfileRepository;
import com.houndcoder.members.dto.ProfileDto;
import com.houndcoder.members.dto.ProfileRequest;
import com.houndcoder.members.dto.ProfileResponse;
import com.houndcoder.members.exception.ProfileNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.houndcoder.members.exception.MemberNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {
    private final MemberRepository memberRepository;
    private final ProfileRepository profileRepository;

    public ProfileResponse findBasicProfile(final Long memberId) {
        Profile profile = findProfileByMember(memberId);
        ProfileResponse profileDto = ProfileResponse.builder()
                .nickname(profile.getMember().getUsername())
                .emil(profile.getMember().getEmail())
                .introduction(profile.getIntroduction())
                .build();
        return new ProfileResponse(profileDto);
    }

    public ProfileResponse updateBasicProfile(Long memberId, ProfileRequest dto) {
        Profile profile = findProfileByMember(memberId);
        profile.updateIntroduction(dto.);
        return new ProfileDto();
    }

    private Member findMemberById(final Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
    }

    private Profile findProfileByMember(final Long memberId) {
        Member member = findMemberById(memberId);
        return profileRepository.findByMember(member)
                .orElseThrow(ProfileNotFoundException::new);
    }
}
