package com.lazy.domain.user.assembler;

import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.po.ShortLinkPO;

public class ShortLinkAssembler {
    public static ShortLinkPO toPO(ShortLink shortLink) {
        ShortLinkPO shortLinkPO = new ShortLinkPO();
        shortLinkPO.setId(shortLink.getId())
                .setShortCode(shortLink.getShortCode())
                .setOriginalUrl(shortLink.getOriginalUrl())
                .setCreatedBy(shortLink.getCreatedBy())
                .setCreatedAt(shortLink.getCreatedAt())
                .setUpdatedBy(shortLink.getUpdatedBy())
                .setUpdatedAt(shortLink.getUpdatedAt());
        return shortLinkPO;
    }

    public static ShortLink toDO(ShortLinkPO shortLinkPO) {
        if (shortLinkPO == null) {
            return null;
        }

        ShortLink shortLink = new ShortLink();
        shortLink.setId(shortLinkPO.getId())
                .setShortCode(shortLinkPO.getShortCode())
                .setOriginalUrl(shortLinkPO.getOriginalUrl())
                .setCreatedBy(shortLinkPO.getCreatedBy())
                .setCreatedAt(shortLinkPO.getCreatedAt())
                .setUpdatedBy(shortLinkPO.getUpdatedBy())
                .setUpdatedAt(shortLinkPO.getUpdatedAt());
        return shortLink;
    }
}
