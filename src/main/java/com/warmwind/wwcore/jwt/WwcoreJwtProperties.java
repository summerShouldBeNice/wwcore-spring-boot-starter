package com.warmwind.wwcore.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author warmwind
 * @createTime 2024-02-29 00:04
 */
@ConfigurationProperties(prefix = "wwcore.jwt")
public class WwcoreJwtProperties {

    /**
     * 密钥
     */
    private String secret;

    /**
     * 过期时间
     */
    private int expire;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }


    @Override
    public String toString() {
        return "WwcoreJwtProperties{" +
                "secret='" + secret + '\'' +
                ", expire=" + expire +
                '}';
    }
}
