package com.warmwind.wwcore.captcha;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author warmwind
 * @createTime 2024-03-05 18:32
 */
@AutoConfiguration
@EnableConfigurationProperties(WwcoreCaptchaProperties.class)
@ConditionalOnClass(WwcoreCaptchaProperties.class)
public class WwcoreCaptchaAutoConfigure {

    @Bean
    @ConditionalOnProperty(name = "wwcore.captcha.enable", havingValue = "true")
    public WwcoreCaptchaService wwcoreCaptchaService(WwcoreCaptchaProperties wwcoreCaptchaProperties) {
        WwcoreCaptchaService wwcoreCaptchaService = new WwcoreCaptchaService();
        wwcoreCaptchaService.setWwcoreCaptchaProperties(wwcoreCaptchaProperties);
        return wwcoreCaptchaService;
    }

}
