package com.houndcoder.friends.domain;

import com.houndcoder.members.domain.Member;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "messages")
public class Message extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Member sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Member receiver;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;
}
