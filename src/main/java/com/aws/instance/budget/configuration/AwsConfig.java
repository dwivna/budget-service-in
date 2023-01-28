package com.aws.instance.budget.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "aws")
public class AwsConfig {
    private String accessKey;
    private String secretKey;
    private String region;
    private String endpoint;
}
