package com.lazy.application.service;

import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.facade.ShortLinkRepository;
import com.lazy.domain.shortlink.service.ShortLinkDomainService;
import com.lazy.application.dto.CreateShortLinkRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateShortLinkAppService {
    private final ShortLinkRepository shortLinkRepository;
    private final ShortLinkDomainService shortLinkDomainService;

    public void createShortLink(CreateShortLinkRequest createShortLinkRequest) {
        ShortLink shortLink = ShortLink.create(createShortLinkRequest.getOriginalUrl(), createShortLinkRequest.getCreateBy());
        shortLinkDomainService.generateUniqueShortCode(shortLink);
        shortLinkRepository.save(shortLink);
    }
}
