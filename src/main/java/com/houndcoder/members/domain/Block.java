package com.houndcoder.members.domain;

import com.houndcoder.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter @SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blocks")
public class Block extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blocker_id", nullable = false)
    private Member blocker;

    @ManyToOne
    @JoinColumn(name = "blocked_id", nullable = false)
    private Member blocked;
}
