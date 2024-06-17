package com.houndcoder.members.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "kakao_id")
    private String kakaoId;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "github_id")
    private String githubId;

    @Column(name = "last_login")
    private LocalDateTime lastLogin; // 최근 접속일
}
