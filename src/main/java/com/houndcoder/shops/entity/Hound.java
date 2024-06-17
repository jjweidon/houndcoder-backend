package com.houndcoder.shops.entity;

import com.houndcoder.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hounds")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hound extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}
