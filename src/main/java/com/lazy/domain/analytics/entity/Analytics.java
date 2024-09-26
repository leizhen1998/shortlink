package com.lazy.domain.analytics.entity;

import com.lazy.domain.analytics.entity.vo.Location;
import com.lazy.domain.analytics.entity.vo.UserAgent;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Analytics {
    private String shortCode;

    private String referer;

    private Location location;

    private UserAgent userAgent;

    public static Analytics create(String shortCode, String referer, Location location, UserAgent userAgent) {
        Analytics analytics = new Analytics();
        analytics.setShortCode(shortCode)
                .setReferer(referer)
                .setLocation(location)
                .setUserAgent(userAgent);
        return analytics;
    }
}
