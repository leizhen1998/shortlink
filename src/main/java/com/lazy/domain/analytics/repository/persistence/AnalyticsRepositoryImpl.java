package com.lazy.domain.analytics.repository.persistence;

import com.lazy.domain.analytics.entity.Analytics;
import com.lazy.domain.analytics.repository.dao.AnalyticsDao;
import com.lazy.domain.analytics.repository.facade.AnalyticsRepository;
import com.lazy.domain.analytics.repository.po.AnalyticsPO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AnalyticsRepositoryImpl implements AnalyticsRepository {
    private final AnalyticsDao analyticsDao;

    @Override
    public void save(Analytics analytics) {
        AnalyticsPO analyticsPO = new AnalyticsPO();
        BeanUtils.copyProperties(analytics, analyticsPO);
        BeanUtils.copyProperties(analytics.getLocation(), analyticsPO);
        BeanUtils.copyProperties(analytics.getUserAgent(), analyticsPO);

        analyticsDao.save(analyticsPO);
    }
}
