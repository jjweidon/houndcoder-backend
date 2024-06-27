package com.houndcoder.members.domain.repository;

import com.houndcoder.members.domain.Member;
import com.houndcoder.members.domain.Profile;
import com.houndcoder.members.exception.MemberNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByMember(Member member);
}
