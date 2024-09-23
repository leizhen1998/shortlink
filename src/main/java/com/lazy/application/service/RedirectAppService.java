package com.lazy.application.service;

import com.ip2location.IPResult;
import com.lazy.application.dto.RedirectRequest;
import com.lazy.application.dto.RedirectResponse;
import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.facade.ShortLinkRepository;
import com.lazy.infrastructure.util.IPUtils;
import com.lazy.infrastructure.util.UserAgentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class RedirectAppService {
    private final ShortLinkRepository shortLinkRepository;

    public RedirectAppService(ShortLinkRepository shortLinkRepository) {
        this.shortLinkRepository = shortLinkRepository;
    }

    public RedirectResponse redirect(RedirectRequest redirectRequest) throws IOException {
        ShortLink shortLink = shortLinkRepository.findByShortCode(redirectRequest.shortCode());
        if (shortLink == null) {
            return new RedirectResponse("https://github.com/404");
        }

        Map<String, String> uaParseInfo = UserAgentUtils.parse(redirectRequest.userAgent());
        uaParseInfo.entrySet().forEach(s -> System.out.println(s));

        IPResult location = IPUtils.getLocation(redirectRequest.clientIp());
        System.out.println(location);
        return new RedirectResponse(shortLink.getOriginalUrl());
    }
}
