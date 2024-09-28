package com.houndcoder.friends.domain;

import com.houndcoder.friends.domain.enums.MessageStatus;
import com.houndcoder.global.domain.BaseTime;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "friendship_id")
    private Friendship friendship;

    @Column(length = 500)
    private String content;

    private LocalDateTime readAt;

    @Enumerated(EnumType.STRING)
    private MessageStatus status;
}
