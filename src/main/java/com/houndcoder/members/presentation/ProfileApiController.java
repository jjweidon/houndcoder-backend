package com.houndcoder.members.presentation;

import com.houndcoder.global.ResponseDto;
import com.houndcoder.members.application.ProfileService;
import com.houndcoder.members.dto.ProfileDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
//@RequestMapping("/api/v1/members")
public class ProfileApiController {
    private final ProfileService profileService;

    @GetMapping("/{memberId}/basic")
    public ResponseEntity<ResponseDto> getBasicProfile(@PathVariable("memberId") Long memberId) {
        log.info("Request to get basic profile by id-{}", memberId);
        ProfileDto.GetResponse response = profileService.findBasicProfile(memberId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PutMapping("/me/basic")
//    public ResponseEntity<ResponseDto> putBasicProfile(Authentication authentication) {
//        log.info("Request to put basic profile by id-{}", authentication.getPrincipal());
//        ProfileDto.PutResponse response = profileService.updateBasicProfile(authentication);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
