package com.houndcoder.friends.domain;

import com.houndcoder.members.entity.Member;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "friend_requests")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    // Getter and Setter methods
}