package com.lazy.domain.shortlink.repository.dao;

import com.lazy.domain.shortlink.repository.po.ShortLinkPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkDao extends JpaRepository<ShortLinkPO, Long> {
    boolean existsByShortCode(String shortCode);

    ShortLinkPO findShortLinkPOByShortCode(String shortCode);
}
