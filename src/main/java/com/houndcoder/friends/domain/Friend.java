package com.houndcoder.friends.domain;

import com.houndcoder.friends.domain.enums.FriendStatus;
import com.houndcoder.members.domain.Member;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "friends")
public class Friend extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member1_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "member2_id", nullable = false)
    private Member friend;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FriendStatus status;
}
