package com.houndcoder.members.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.houndcoder.global.domain.BaseTime;
import com.houndcoder.members.domain.enums.Tier;
import com.houndcoder.members.dto.BasicProfileDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "profiles")
public class Profile extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member member;

    private String bio;

    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerLanguage> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerPosition> positions;

    private Tier tier;

    private int rank;

    private int score;

    @JsonIgnore
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerHound> hounds;

    public void updateBio(final String bio) {
        this.bio = bio;
    }

    public void updateImageUrl(final String newUrl) {
        this.imageUrl = newUrl;
    }

    public void updateScore(final int score) {
        this.score = score;
    }

    public void updateRank(final int rank) {
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
}