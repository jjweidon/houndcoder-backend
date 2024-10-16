package com.houndcoder.members.domain;

import com.houndcoder.global.domain.BaseTime;
import com.houndcoder.members.domain.enums.AuthProvider;
import com.houndcoder.members.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Builder @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void updatePassword(final String password) { this.password = password; }
}
