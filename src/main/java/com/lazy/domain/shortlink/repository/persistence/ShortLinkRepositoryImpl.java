package com.lazy.domain.shortlink.repository.persistence;

import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.dao.ShortLinkDao;
import com.lazy.domain.shortlink.repository.facade.ShortLinkRepository;
import com.lazy.domain.shortlink.repository.po.ShortLinkPO;
import com.lazy.domain.user.assembler.ShortLinkAssembler;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class ShortLinkRepositoryImpl implements ShortLinkRepository {
    private final ShortLinkDao shortLinkDao;

    public ShortLinkRepositoryImpl(ShortLinkDao shortLinkDao) {
        this.shortLinkDao = shortLinkDao;
    }

    @Override
    public boolean existsByShortCode(String shortCode) {
        return shortLinkDao.existsByShortCode(shortCode);
    }

    @Override
    public void save(ShortLink shortLink) {
        shortLink.setCreatedAt(LocalDateTime.now());
        ShortLinkPO shortLinkPO = ShortLinkAssembler.toPO(shortLink);
        shortLinkDao.save(shortLinkPO);
    }

    @Override
    public ShortLink findByShortCode(String shortCode) {
        ShortLinkPO shortLinkPO =  shortLinkDao.findShortLinkPOByShortCode(shortCode);
        ShortLink shortLink = ShortLinkAssembler.toDO(shortLinkPO);
        return shortLink;
    }
}
