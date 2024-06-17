package com.houndcoder.games.domain;

import com.houndcoder.games.domain.vo.Difficulty;
import com.houndcoder.games.domain.vo.Language;
import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "code_examples")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
