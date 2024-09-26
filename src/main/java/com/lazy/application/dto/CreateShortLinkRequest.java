package com.lazy.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateShortLinkRequest{
        @NotBlank(message = "originalUrl must not be empty")
        private String originalUrl;

        private Long createBy;
}
