package com.example.appwebbellac;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="com.example.appwebbellac")
public class CustomProperties {
    private String apiUrl;
}
