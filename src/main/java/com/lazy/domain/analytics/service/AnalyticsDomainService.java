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

        Location location = new Location(
                event.getClientIp(),
                ipResult.getCountryLong(),
                ipResult.getRegion(),
                ipResult.getCity(),
                ipResult.getLatitude(),
                ipResult.getLongitude(),
                ipResult.getZipCode(),
                ipResult.getTimeZone());

        UserAgent userAgent = new UserAgent(
                event.getUserAgent(),
                parsedUserAgent.get("DeviceClass"),
                parsedUserAgent.get("DeviceName"),
                parsedUserAgent.get("DeviceBrand"),
                parsedUserAgent.get("OperatingSystemClass"),
                parsedUserAgent.get("OperatingSystemName"),
                parsedUserAgent.get("OperatingSystemVersion"),
                parsedUserAgent.get("OperatingSystemVersionMajor"),
                parsedUserAgent.get("OperatingSystemVersionBuild"),
                parsedUserAgent.get("LayoutEngineClass"),
                parsedUserAgent.get("LayoutEngineName"),
                parsedUserAgent.get("LayoutEngineVersion"),
                parsedUserAgent.get("LayoutEngineVersionMajor"),
                parsedUserAgent.get("AgentClass"),
                parsedUserAgent.get("AgentName"),
                parsedUserAgent.get("AgentVersion"),
                parsedUserAgent.get("AgentVersionMajor"),
                parsedUserAgent.get("AgentLanguage"),
                parsedUserAgent.get("AgentLanguageCode"),
                parsedUserAgent.get("AgentSecurity"),
                parsedUserAgent.get("WebviewAppName"),
                parsedUserAgent.get("WebviewAppVersion"),
                parsedUserAgent.get("WebviewAppVersionMajor")
        );

        Analytics analytics = Analytics.create(event.getShortCode(), event.getReferer(), location, userAgent);
        analyticsRepository.save(analytics);
    }
}
