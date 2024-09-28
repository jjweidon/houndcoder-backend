package com.houndcoder.members.domain.repository;

import com.houndcoder.members.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
    boolean existByNickname(String nickname);
    Optional<Member> findByNickname(String nickname);
    Optional<Member> findByEmail(String email);
}
