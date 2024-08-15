package com.houndcoder.friends.domain.repository;

import com.houndcoder.friends.domain.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friendship, Long> {
}
