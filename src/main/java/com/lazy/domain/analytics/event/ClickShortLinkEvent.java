package com.lazy.domain.analytics.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClickShortLinkEvent{
    private String shortCode;
    private String clientIp;
    private String referer;
    private String userAgent;
}
