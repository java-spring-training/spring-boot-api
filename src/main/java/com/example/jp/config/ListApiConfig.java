package com.example.jp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.list")
@Data
public class ListApiConfig {

    private String host;
    private String port;
    private String path;
}
