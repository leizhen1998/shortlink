package com.lazy.application.dto;

public record RedirectRequest (
        String shortCode,
        String clientIp,
        String referer,
        String userAgent
) {
}
