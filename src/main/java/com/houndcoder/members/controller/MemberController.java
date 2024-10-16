package com.houndcoder.members.controller;

import com.houndcoder.auth.dto.CustomUserDetails;
import com.houndcoder.global.domain.Language;
import com.houndcoder.global.dto.Response;
import com.houndcoder.global.dto.ResponseDto;
import com.houndcoder.global.service.S3Service;
import com.houndcoder.members.domain.PlayerLanguage;
import com.houndcoder.members.dto.PlayerLanguagesRequest;
import com.houndcoder.members.dto.PlayerLanguagesResponse;
import com.houndcoder.members.dto.ProfileRequest;
import com.houndcoder.members.dto.ProfileResponse;
import com.houndcoder.members.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final ProfileService profileService;
    private final S3Service s3Service;

    // 기본 정보 조회
    @GetMapping("/{memberId}/profile/basic")
    public ResponseEntity<Response<ResponseDto>> getBasicProfile(Authentication authentication, @PathVariable("memberId") Long memberId) {
        log.info("Request to GET basic profile by id - {}", memberId);
        ProfileResponse response = profileService.findBasicProfile(memberId);
        return new ResponseEntity<>(Response.success(response), HttpStatus.OK);
    }

    // 기본 정보 수정
    @PutMapping("/me/profile/basic")
    public ResponseEntity<Response<ResponseDto>> putBasicProfile(Authentication authentication, @RequestBody ProfileRequest request) {
        Long memberId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        log.info("Request to PUT basic profile of member- {}", memberId);
        ProfileResponse response = profileService.updateBasicProfile(memberId, request);
        return new ResponseEntity<>(Response.success(response), HttpStatus.OK);
    }

    // 프로필 이미지 수정
    @PutMapping("/members/me/profile/image")
    public ResponseEntity<Response<ResponseDto>> putProfileImage(Authentication authentication, @RequestParam MultipartFile file) {
        Long memberId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        log.info("Request to PUT profile image of member - {}", memberId);
        String imageUrl = s3Service.uploadFile(file);
        ProfileResponse response = profileService.updateProfileImage(memberId, imageUrl);
        return new ResponseEntity<>(Response.success(response), HttpStatus.OK);
    }

    // 주력 언어 조회
    @GetMapping("/{memberId}/positions")
    public ResponseEntity<Response<ResponseDto>> getMemberLanguages(@PathVariable("memberId") Long memberId) {
        log.info("Request to GET languages of member - {}", memberId);
        PlayerLanguagesResponse response = profileService.getMemberLanguages(memberId);
        return new ResponseEntity<>(Response.success(response), HttpStatus.OK);
    }

    // 주력 언어 수정
    @PutMapping("/me/positions")
    public ResponseEntity<Response<ResponseDto>> updateMemberLanguages(Authentication authentication, @RequestBody PlayerLanguagesRequest request) {
        Long memberId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        log.info("Request to PUT languages of member - {}", memberId);
        PlayerLanguagesResponse response = profileService.updateMemberLanguages(memberId, request);
        return new ResponseEntity<>(Response.success(response), HttpStatus.OK);
    }
}