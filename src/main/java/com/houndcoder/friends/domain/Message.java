package com.houndcoder.friends.domain;

import com.houndcoder.members.entity.Member;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    // Getter and Setter methods
}
