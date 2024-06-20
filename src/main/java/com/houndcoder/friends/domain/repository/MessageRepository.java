package com.houndcoder.friends.domain.repository;

import com.houndcoder.friends.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
