package com.houndcoder.auth.service;

import com.houndcoder.auth.dto.CustomUserDetails;
import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.repository.MemberRepository;
import com.houndcoder.members.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member userData = memberRepository.findByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        if (userData != null) {
            //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
            log.info("Authentication Manager work with {}", email);
            return new CustomUserDetails(userData);
        }
        return null;
    }
}