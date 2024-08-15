package com.houndcoder.members.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.houndcoder.global.domain.BaseEntity;
import com.houndcoder.members.domain.enums.Tier;
import com.houndcoder.members.dto.BasicProfileDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "profiles")
public class Profile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member member;

    private String introduction; // 한 줄 소개

    private String imageUrl; // 프로필 이미지 url

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerLanguage> languages; // 최대 5개의 주력 언어

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerPosition> positions; // 최대 5개의 포지션

    private Tier tier; // 37단계의 티어

    private int rank; // 전체 순위

    private int score; // 점수

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerHound> hounds; // 사용자의 하운드

    public void updateIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void updateImageUrl(String newUrl) {
        this.imageUrl = newUrl;
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

    public void setPlayerLanguages(List<PlayerLanguage> playerLanguages) {
        if (playerLanguages.size() > 5) {
            throw new IllegalArgumentException("Player can select up to 5 languages.");
        }
        this.languages = playerLanguages;
    }

    public void setPlayerPositions(List<PlayerPosition> playerPositions) {
        if (playerPositions.size() > 5) {
            throw new IllegalArgumentException("Player can select up to 5 positions.");
        }
        this.positions = playerPositions;
    }

    public void updateWith(final BasicProfileDto dto) {
        this.introduction = dto.getIntroduction();
    }
}