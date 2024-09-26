package com.lazy.domain.analytics.repository.persistence;

import com.lazy.domain.analytics.assembler.AnalyticsAssembler;
import com.lazy.domain.analytics.entity.Analytics;
import com.lazy.domain.analytics.repository.dao.AnalyticsDao;
import com.lazy.domain.analytics.repository.facade.AnalyticsRepository;
import com.lazy.domain.analytics.repository.po.AnalyticsPO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@AllArgsConstructor
public class AnalyticsRepositoryImpl implements AnalyticsRepository {
    private final AnalyticsDao analyticsDao;

    @Override
    public void save(Analytics analytics) {
        analytics.setCreatedAt(LocalDateTime.now());
        AnalyticsPO analyticsPO = AnalyticsAssembler.INSTANCE.toPO(analytics);
        analyticsDao.save(analyticsPO);
    }
}
