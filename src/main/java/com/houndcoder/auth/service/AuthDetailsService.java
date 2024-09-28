package com.houndcoder.auth.service;

import com.houndcoder.auth.dto.AuthDetails;
import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.repository.MemberRepository;
import com.houndcoder.members.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member userData = memberService.findMemberByEmail(email);

        if (userData != null) {
            return new AuthDetails(userData);
        }

        return null;
    }
}