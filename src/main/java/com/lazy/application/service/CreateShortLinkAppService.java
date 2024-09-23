package com.lazy.application.service;

import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.facade.ShortLinkRepository;
import com.lazy.domain.shortlink.service.ShortLinkDomainService;
import com.lazy.application.dto.CreateShortLinkRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateShortLinkAppService {
    private final ShortLinkRepository shortLinkRepository;

    private final ShortLinkDomainService shortLinkDomainService;

    public CreateShortLinkAppService(ShortLinkRepository shortLinkRepository,
                                     ShortLinkDomainService shortLinkDomainService) {
        this.shortLinkRepository = shortLinkRepository;
        this.shortLinkDomainService = shortLinkDomainService;
    }

    public void createShortLink(CreateShortLinkRequest createShortLinkRequest) {
        ShortLink shortLink = ShortLink.create(createShortLinkRequest.originalUrl(), createShortLinkRequest.createBy());
        shortLinkDomainService.generateUniqueShortCode(shortLink);
        shortLinkRepository.save(shortLink);
    }
}
