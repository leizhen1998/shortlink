package com.lazy.domain.analytics.service;

import com.ip2location.IPResult;
import com.lazy.domain.analytics.event.ClickShortLinkEvent;
import com.lazy.infrastructure.util.IPUtils;
import com.lazy.infrastructure.util.UserAgentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class ClickShortLinkEventService {

    public void handle(ClickShortLinkEvent event) throws IOException {
        IPResult location = IPUtils.getLocation(event.getClientIp());
        Map<String, String> parsedUserAgent = UserAgentUtils.parse(event.getUserAgent());

        log.info("location: {}", location);
        log.info("parsedUserAgent: {}", parsedUserAgent);
    }
}
