package com.houndcoder.auth.controller;

import com.houndcoder.auth.dto.SignupRequest;
import com.houndcoder.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        log.info("signup email: {}", signupRequest.getEmail());
        authService.joinProcess(signupRequest);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}