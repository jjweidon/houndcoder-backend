package com.houndcoder.members.entity;

import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blocks")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
