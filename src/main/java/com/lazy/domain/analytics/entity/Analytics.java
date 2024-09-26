package com.lazy.domain.analytics.entity;

import com.lazy.domain.analytics.entity.vo.Location;
import com.lazy.domain.analytics.entity.vo.UserAgent;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Analytics {
    private String shortCode;

    private LocalDateTime clickTime;

    private String referer;

    private Location location;

    private UserAgent userAgent;

    private LocalDateTime createdAt;

    public static Analytics create(String shortCode, LocalDateTime clickTime, String referer, Location location, UserAgent userAgent) {
        Analytics analytics = new Analytics();
        analytics.setShortCode(shortCode)
                .setClickTime(clickTime)
                .setReferer(referer)
                .setLocation(location)
                .setUserAgent(userAgent);
        return analytics;
    }
}
