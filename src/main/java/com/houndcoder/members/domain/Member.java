package com.houndcoder.members.domain;

import com.houndcoder.members.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter @SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String kakaoId;

    private String googleId;

    private String githubId;

    private LocalDateTime lastLogin; // 최근 접속일

    @Enumerated(EnumType.STRING)
    private Role role;

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
}
