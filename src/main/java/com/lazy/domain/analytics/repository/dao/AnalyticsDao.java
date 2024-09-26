package com.lazy.domain.analytics.repository.dao;

import com.lazy.domain.analytics.repository.po.AnalyticsPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsDao extends JpaRepository<AnalyticsPO, Long> {
}
