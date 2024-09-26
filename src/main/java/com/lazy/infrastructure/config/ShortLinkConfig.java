package com.lazy.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "shortlink.config")
@Configuration
public class ShortLinkConfig {
    private String defaultNotFoundUrl;
}
