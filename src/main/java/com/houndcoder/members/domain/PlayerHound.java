package com.houndcoder.members.domain;

import com.houndcoder.shops.domain.Hound;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "player_hounds")
public class PlayerHound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member player;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hound hound;

    private Date gotchaDate;

    private int playCount;

    private int bestScore;
}
