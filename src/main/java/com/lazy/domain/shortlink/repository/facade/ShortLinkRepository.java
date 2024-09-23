package com.lazy.domain.shortlink.repository.facade;

import com.lazy.domain.shortlink.entity.ShortLink;

public interface ShortLinkRepository {
    boolean existsByShortCode(String shortCode);

    void save(ShortLink shortLink);

    ShortLink findByShortCode(String shortCode);
}
