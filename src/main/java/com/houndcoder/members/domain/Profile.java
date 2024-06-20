package com.houndcoder.members.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.houndcoder.games.domain.enums.Language;
import com.houndcoder.global.BaseEntity;
import com.houndcoder.members.domain.enums.Position;
import com.houndcoder.shops.domain.Hound;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "profiles")
public class Profile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member member;

    private String introduction; // 한 줄 소개

    @ElementCollection(targetClass = Language.class)
    @CollectionTable(name = "profile_languages", joinColumns = @JoinColumn(name = "profile_id"))
    @Enumerated(EnumType.STRING)
    private Set<Language> languages; // 최대 5개의 주력 언어

    @ElementCollection(targetClass = Position.class)
    @CollectionTable(name = "profile_positions", joinColumns = @JoinColumn(name = "profile_id"))
    @Enumerated(EnumType.STRING)
    private Set<Position> positions; // 최대 5개의 포지션

    private int rankLevel; // 37단계의 랭크

    private int overallRank; // 전체 순위

    private int score; // 점수

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Hound selectedHound; // 설정된 하운드
}