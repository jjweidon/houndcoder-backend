package com.houndcoder.members.domain;

import com.houndcoder.global.domain.Language;
import com.houndcoder.global.domain.BaseEntity;
import com.houndcoder.members.domain.enums.Position;
import com.houndcoder.members.domain.enums.Tier;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter @SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "profiles")
public class Profile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member member;

    private String introduction; // 한 줄 소개

    private String profileImage; // 프로필 이미지 url

    @ElementCollection(targetClass = Language.class)
    @CollectionTable(name = "profile_languages", joinColumns = @JoinColumn(name = "profile_id"))
    @Enumerated(EnumType.STRING)
    private Set<Language> languages; // 최대 5개의 주력 언어

    @ElementCollection(targetClass = Position.class)
    @CollectionTable(name = "profile_positions", joinColumns = @JoinColumn(name = "profile_id"))
    @Enumerated(EnumType.STRING)
    private Set<Position> positions; // 최대 5개의 포지션

    private Tier tier; // 37단계의 티어

    private int rank; // 전체 순위

    private int score; // 점수

    @ManyToOne(fetch = FetchType.LAZY)
    private PlayerHound selectedHound; // 설정된 하운드

    public void updateIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void updateProfileImage(String newUrl) {
        this.profileImage = newUrl;
    }

    public void updateScore(int score) {
        this.score = score;
    }

    public void updateRank(int rank) {
        this.rank = rank;
    }

    public void updateTier() {
        int currentRank = this.rank;
        int currentScore = this.score;

        if (currentScore >= 1000 && currentRank == 1) {
            this.tier = Tier.CHAMPION;
        } else if (currentScore >= 1000 && currentRank <= 10) {
            this.tier = Tier.MASTER;
        } else if (currentScore >= 1000 && currentRank <= 50) {
            this.tier = Tier.RUBY1;
        } else {
            this.tier = Tier.IRON5;
        }
    }
}