package com.lazy.domain.analytics.service;

import com.ip2location.IPResult;
import com.lazy.domain.analytics.entity.Analytics;
import com.lazy.domain.analytics.entity.vo.Location;
import com.lazy.domain.analytics.entity.vo.UserAgent;
import com.lazy.domain.analytics.event.ClickShortLinkEvent;
import com.lazy.domain.analytics.repository.facade.AnalyticsRepository;
import com.lazy.infrastructure.util.IPUtils;
import com.lazy.infrastructure.util.UserAgentUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class AnalyticsDomainService {
    private final AnalyticsRepository analyticsRepository;

    public void handleEvent(ClickShortLinkEvent event) throws IOException {
        IPResult ipResult = IPUtils.getLocation(event.getClientIp());
        Map<String, String> parsedUserAgent = UserAgentUtils.parse(event.getUserAgent());

        Location location = new Location(event.getClientIp(), ipResult);
        UserAgent userAgent = new UserAgent(event.getUserAgent(), parsedUserAgent);

        Analytics analytics = Analytics.create(event.getShortCode(), event.getClickTime(), event.getReferer(), location, userAgent);
        analyticsRepository.save(analytics);
    }
}
