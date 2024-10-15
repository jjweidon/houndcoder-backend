package com.houndcoder.members.service;

import com.houndcoder.global.service.GlobalService;
import com.houndcoder.members.domain.PlayerLanguage;
import com.houndcoder.members.domain.Profile;
import com.houndcoder.members.domain.repository.ProfileRepository;
import com.houndcoder.members.dto.PlayerLanguagesRequest;
import com.houndcoder.members.dto.PlayerLanguagesResponse;
import com.houndcoder.members.dto.ProfileRequest;
import com.houndcoder.members.dto.ProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {
    private final ProfileRepository profileRepository;

    private final GlobalService globalService;

    @Transactional(readOnly = true)
    public ProfileResponse findBasicProfile(final Long memberId) {
        Profile profile = globalService.findProfileByMemberId(memberId);
        return ProfileResponse.builder()
                .nickname(profile.getNickname())
                .email(profile.getMember().getEmail())
                .bio(profile.getBio())
                .build();
    }

    @Transactional
    public ProfileResponse updateBasicProfile(Long memberId, ProfileRequest dto) {
        Profile profile = globalService.findProfileByMemberId(memberId);
        profile.updateBio(dto.getBio());
        profile.updateNickname(dto.getNickname());
        profileRepository.save(profile);
        return ProfileResponse.createWith(profile);
    }

    @Transactional
    public ProfileResponse updateProfileImage(Long memberId, String imageUrl) {
        Profile profile = globalService.findProfileByMemberId(memberId);
        profile.updateImageUrl(imageUrl);
        profileRepository.save(profile);
        return ProfileResponse.createWith(profile);
    }

    @Transactional(readOnly = true)
    public PlayerLanguagesResponse getMemberLanguages(Long memberId) {
        Profile profile = globalService.findProfileByMemberId(memberId);
        List<PlayerLanguage> languages = profile.getLanguages();
        return PlayerLanguagesResponse.createWith(languages);
    }

    @Transactional
    public PlayerLanguagesResponse updateMemberLanguages(Long memberId, PlayerLanguagesRequest request) {
        Profile profile = globalService.findProfileByMemberId(memberId);
        List<PlayerLanguage> newLanguages = request.getLanguages().stream()
                .map(language -> PlayerLanguage.builder()
                        .profile(profile)
                        .language(language)
                        .build())
                .collect(Collectors.toList());
        profile.setPlayerLanguages(newLanguages);
        return PlayerLanguagesResponse.createWith(newLanguages);
    }
}