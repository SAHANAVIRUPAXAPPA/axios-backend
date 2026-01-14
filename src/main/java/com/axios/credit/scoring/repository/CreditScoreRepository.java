package com.axios.credit.scoring.repository;

import com.axios.credit.scoring.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CreditScoreRepository extends JpaRepository<CreditScore, UUID> {

    Optional<CreditScore> findTopByUserIdOrderByGeneratedAtDesc(UUID userId);
}
