package com.lazy.domain.shortlink.entity;

import com.google.common.hash.Hashing;
import com.lazy.infrastructure.util.NumberUtils;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ShortLink {
    private Long id;

    private String shortCode;

    private String originalUrl;

    private Long createdBy;

    private LocalDateTime createdAt;

    private Long updatedBy;

    private LocalDateTime updatedAt;

    public static ShortLink create(String originalUrl, Long createdBy) {
        ShortLink shortLink = new ShortLink();
        shortLink.setOriginalUrl(originalUrl)
                .setCreatedBy(createdBy);
        return shortLink;
    }

    public String generateShortCode(String suffix) {
        long shortCodeNum = Hashing.murmur3_32_fixed().hashUnencodedChars(originalUrl + suffix).padToLong();
        String base62 = NumberUtils.toBase62(shortCodeNum);
        String shortCode;
        if (base62.length() == 7) {
            shortCode = base62;
        } else if (base62.length() > 7) {
            shortCode = base62.substring(0, 7);
        } else {
            shortCode = "0".repeat(7 - base62.length()) + base62;
        }
        this.setShortCode(shortCode);
        return shortCode;
    }
}
