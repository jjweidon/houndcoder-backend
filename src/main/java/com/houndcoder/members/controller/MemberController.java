package com.houndcoder.members.controller;

import com.houndcoder.auth.dto.CustomUserDetails;
import com.houndcoder.global.dto.ResponseDto;
import com.houndcoder.members.dto.ProfileRequest;
import com.houndcoder.members.dto.ProfileResponse;
import com.houndcoder.members.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final ProfileService profileService;

    // 기본 정보 조회
    @GetMapping("/{memberId}/profile/basic")
    public ResponseEntity<ResponseDto> getBasicProfile(Authentication authentication, @PathVariable("memberId") Long memberId) {
        log.info("Request to GET basic profile by id - {}", memberId);
        ProfileResponse response = profileService.findBasicProfile(memberId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 기본 정보 수정
    @PutMapping("/me/profile/basic")
    public ResponseEntity<ResponseDto> putBasicProfile(Authentication authentication, @RequestBody ProfileRequest request) {
        Long memberId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        log.info("Request to PUT basic profile by id-{}", memberId);
        ProfileResponse response = profileService.updateBasicProfile(memberId, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}