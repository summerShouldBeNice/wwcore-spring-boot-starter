package com.warmwind.wwcore.jwt;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author warmwind
 * @createTime 2024-02-29 00:04
 */
@AutoConfiguration
@EnableConfigurationProperties(WwcoreJwtProperties.class)
public class WwcoreJwtAutoConfiguration {

    @Bean
    public WwcoreJwtUtils coreJwtUtils(WwcoreJwtProperties coreJwtProperties) {
        WwcoreJwtUtils coreJwtUtils = new WwcoreJwtUtils();
        coreJwtUtils.setCoreJwtProperties(coreJwtProperties);
        return coreJwtUtils;
    }
}
