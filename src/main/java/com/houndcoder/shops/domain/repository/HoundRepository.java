package com.houndcoder.shops.domain.repository;

import com.houndcoder.shops.domain.Hound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoundRepository extends JpaRepository<Hound, Long> {
}
