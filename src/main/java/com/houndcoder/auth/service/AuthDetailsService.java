package com.houndcoder.auth.service;

import com.houndcoder.auth.dto.AuthDetails;
import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member userData = memberRepository.findByUsername(username);

        if (userData != null) {

            return new AuthDetails(userData);
        }

        return null;
    }
}