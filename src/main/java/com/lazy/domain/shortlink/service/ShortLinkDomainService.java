package com.lazy.domain.shortlink.service;

import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.facade.ShortLinkRepository;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkDomainService {
    private final ShortLinkRepository shortLinkRepository;

    public ShortLinkDomainService(ShortLinkRepository shortLinkRepository) {
        this.shortLinkRepository = shortLinkRepository;
    }

    public void generateUniqueShortCode(ShortLink shortLink) {
        String shortCode;
        int repeat = 0;
        while (true) {
            shortCode = shortLink.generateShortCode("suffix".repeat(repeat));
            if (!shortLinkRepository.existsByShortCode(shortCode)) {
                break;
            }
            ++repeat;
        }
        shortLink.setShortCode(shortCode);
    }
}
