package com.houndcoder.friends.domain;

import com.houndcoder.friends.domain.enums.FriendStatus;
import com.houndcoder.global.domain.BaseTime;
import com.houndcoder.members.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Friendship extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    private Member friend;

    @Enumerated(EnumType.STRING)
    private FriendStatus status;
}
