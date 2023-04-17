package com.freundebuchag.analytics;

import com.freundebuchag.analytics.TopLongDino.TopLongDino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnalyticRepository extends JpaRepository<TopLongDino, UUID> {
}
