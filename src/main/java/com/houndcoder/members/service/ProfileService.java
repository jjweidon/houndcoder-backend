package com.houndcoder.members.service;

import com.houndcoder.members.domain.Profile;
import com.houndcoder.members.domain.repository.MemberRepository;
import com.houndcoder.members.domain.repository.ProfileRepository;
import com.houndcoder.members.dto.ProfileRequest;
import com.houndcoder.members.dto.ProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {
    private final MemberRepository memberRepository;
    private final ProfileRepository profileRepository;

    public ProfileResponse findBasicProfile(final Long memberId) {
        Profile profile = findProfileByMemberId(memberId);
        return ProfileResponse.builder()
                .nickname(profile.getMember().getNickname())
                .email(profile.getMember().getEmail())
                .introduction(profile.getBio())
                .build();
    }

    public ProfileResponse updateBasicProfile(Long memberId, ProfileRequest dto) {
        Profile profile = findProfileByMemberId(memberId);
        profile.updateIntroduction(dto.);
        return new ProfileDto();
    }

    private Profile findProfileByMemberId(final Long memberId) {
        Member member = findMemberById(memberId);
        return profileRepository.findByMember(member)
                .orElseThrow(ProfileNotFoundException::new);
    }
}
