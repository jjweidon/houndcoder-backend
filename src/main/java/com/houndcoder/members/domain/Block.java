package com.houndcoder.members.domain;

import com.houndcoder.global.domain.BaseTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blocks")
public class Block extends BaseTime {
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
