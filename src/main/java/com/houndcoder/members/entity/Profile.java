package com.houndcoder.members.entity;

import com.houndcoder.shops.entity.Hound;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "profiles")
public class Profile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member member;

    @Column(name = "introduction")
    private String introduction; // 한 줄 소개

    @Column(name = "primary_languages", length = 500)
    private String primaryLanguages; // 최대 5개의 주력 언어

    @Column(name = "positions", length = 500)
    private String positions; // 최대 5개의 포지션

    @Column(name = "rank_level")
    private int rankLevel; // 37단계의 랭크

    @Column(name = "overall_rank")
    private int overallRank; // 전체 순위

    @Column
    private int score; // 점수

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Hound selectedCar; // 설정된
}