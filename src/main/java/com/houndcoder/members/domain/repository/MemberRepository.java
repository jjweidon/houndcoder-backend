package com.houndcoder.members.domain.repository;

import com.houndcoder.members.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
