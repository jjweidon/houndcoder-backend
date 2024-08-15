package com.houndcoder.members.domain;

import com.houndcoder.global.domain.BaseEntity;
import com.houndcoder.members.domain.enums.AuthProvider;
import com.houndcoder.members.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter @Builder @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "members")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
}
