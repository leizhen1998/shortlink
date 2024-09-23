package com.lazy.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateShortLinkRequest(
        @NotBlank(message = "originalUrl must not be empty")
        String originalUrl,

        Long createBy
) {
}
