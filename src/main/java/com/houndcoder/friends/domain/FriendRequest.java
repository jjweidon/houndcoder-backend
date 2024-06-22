package com.houndcoder.friends.domain;

import com.houndcoder.friends.domain.enums.FriendRequestStatus;
import com.houndcoder.members.domain.Member;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "friend_requests")
public class FriendRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Member sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Member receiver;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FriendRequestStatus status;
}