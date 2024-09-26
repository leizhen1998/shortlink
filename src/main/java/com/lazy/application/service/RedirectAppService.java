package com.lazy.application.service;

import com.lazy.application.dto.RedirectRequest;
import com.lazy.application.dto.RedirectResponse;
import com.lazy.application.event.publish.EventPublisher;
import com.lazy.application.event.topic.EventTopicEnum;
import com.lazy.domain.analytics.event.ClickShortLinkEvent;
import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.facade.ShortLinkRepository;
import com.lazy.infrastructure.config.ShortLinkConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RedirectAppService {
    private final ShortLinkConfig shortLinkConfig;
    private final ShortLinkRepository shortLinkRepository;
    private final EventPublisher eventPublisher;

    public RedirectResponse redirect(RedirectRequest redirectRequest) {
        try {
            ShortLink shortLink = shortLinkRepository.findByShortCode(redirectRequest.shortCode());
            if (shortLink == null) {
                log.warn("short link not found for code: {}", redirectRequest.shortCode());
                return new RedirectResponse(shortLinkConfig.getDefaultNotFoundUrl());
            }

            ClickShortLinkEvent clickShortLinkEvent = new ClickShortLinkEvent(redirectRequest.shortCode(), redirectRequest.clientIp(), redirectRequest.referer(), redirectRequest.userAgent());
            eventPublisher.publish(EventTopicEnum.CLICK_SHORT_LINK, clickShortLinkEvent);
            return new RedirectResponse(shortLink.getOriginalUrl());
        } catch (Exception e) {
            log.error("redirect error: redirectRequest = {}, e = {}", redirectRequest, e.getMessage());
            return new RedirectResponse(shortLinkConfig.getDefaultNotFoundUrl());
        }
    }
}
