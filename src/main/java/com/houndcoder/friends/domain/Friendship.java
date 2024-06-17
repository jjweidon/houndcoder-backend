package com.houndcoder.friends.domain;

import com.houndcoder.members.entity.Member;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "friendships")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Friendship extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member1_id", nullable = false)
    private Member member1;

    @ManyToOne
    @JoinColumn(name = "member2_id", nullable = false)
    private Member member2;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FriendshipStatus status;
}
