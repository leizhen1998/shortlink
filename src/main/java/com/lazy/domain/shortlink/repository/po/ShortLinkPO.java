package com.lazy.domain.shortlink.repository.po;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Entity
@Table(name = "shortlink")
@Data
@Accessors(chain = true)
public class ShortLinkPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_code", unique = true, nullable = false, length = 7)
    private String shortCode;

    @Column(name = "original_url", nullable = false, length = 1000)
    private String originalUrl;

    @Column(name = "created_by", nullable = false, updatable = false)
    private Long createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", nullable = true, insertable = false)
    private Long updatedBy;

    @Column(name = "updated_at", nullable = true, insertable = false)
    private LocalDateTime updatedAt;
}
