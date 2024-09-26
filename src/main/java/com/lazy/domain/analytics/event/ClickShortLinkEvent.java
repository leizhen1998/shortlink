package com.lazy.domain.analytics.event;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ClickShortLinkEvent{
    private String shortCode;
    private String clientIp;
    private String referer;
    private String userAgent;
    private LocalDateTime clickTime;

    public static ClickShortLinkEvent create(String shortCode, String clientIp, String referer, String userAgent) {
        ClickShortLinkEvent clickShortLinkEvent = new ClickShortLinkEvent();
        clickShortLinkEvent.setShortCode(shortCode)
                .setClientIp(clientIp)
                .setReferer(referer)
                .setUserAgent(userAgent)
                .setClickTime(LocalDateTime.now());
        return clickShortLinkEvent;
    }
}
