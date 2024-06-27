package com.houndcoder.members.application;

import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.Profile;
import com.houndcoder.members.domain.repository.MemberRepository;
import com.houndcoder.members.domain.repository.ProfileRepository;
import com.houndcoder.members.dto.ProfileDto;
import com.houndcoder.members.exception.ProfileNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.Authentication;

import com.houndcoder.members.exception.MemberNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {
    private final MemberRepository memberRepository;
    private final ProfileRepository profileRepository;

    public ProfileDto.GetResponse findBasicProfile(final Long memberId) {
        Profile profile = findProfileByMember(memberId);
        ProfileDto.Info profileInfo = ProfileDto.Info.builder()
                .nickname(profile.getMember().getNickname())
                .emil(profile.getMember().getEmail())
                .introduction(profile.getIntroduction())
                .build();
        return new ProfileDto.GetResponse(profileInfo);
    }

//    public ProfileDto.PutResponse updateBasicProfile(Authentication authentication) {
//        Profile profile = findProfileByMember();
//        return new ProfileDto.PutResponse();
//    }

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
