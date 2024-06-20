package com.houndcoder.games.domain;

import com.houndcoder.games.domain.enums.Difficulty;
import com.houndcoder.games.domain.enums.Language;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter @Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "code_examples")
public class CodeExample extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @NotNull
    @Column(columnDefinition = "LONGTEXT")
    private String code;
}
